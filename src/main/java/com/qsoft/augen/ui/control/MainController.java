package com.qsoft.augen.ui.control;

import com.qsoft.augen.business.common.StringTemplateService;
import com.qsoft.augen.persistence.entity.MetaColumn;
import com.qsoft.augen.persistence.entity.MetaTable;
import com.qsoft.augen.persistence.entity.PropertyDB;
import com.qsoft.augen.ui.common.DaoUtils;
import com.qsoft.augen.ui.common.ListBinding;
import com.qsoft.augen.ui.common.TableBinding;
import com.qsoft.augen.ui.view.FileChooserGui;
import com.qsoft.augen.ui.view.MainGui;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.FileChooserUI;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Anhnt
 * Date: 8/29/13
 * Time: 12:52 AM
 */
public class MainController
{
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5432/";
    private String user;
    private String password;

    private DaoUtils daoUtils = new DaoUtils();
    private PropertyDB propertyDB;
    private MainGui mainGui;

    private Connection connection;
    private List<String> tables;
    private List<MetaTable> metaTables;

    public MainController()
    {
        mainGui = new MainGui(this);
        mainGui.show();
    }

    public void doGenerate()
    {
        StringTemplateService.genEntity(metaTables);
        StringTemplateService.genDAOInterface(metaTables);
        StringTemplateService.genDaoImpl(metaTables);
        StringTemplateService.genServiceInterface(metaTables);
        StringTemplateService.genServiceImpl(metaTables);
        StringTemplateService.genPomFile();
        StringTemplateService.genPersistenceFile();
        StringTemplateService.genPropertiesFile(propertyDB);
        StringTemplateService.genSpringConfigFile(propertyDB);
    }

    public void doQuit()
    {
        System.exit(0);
    }

    public void doDisConnect()
    {
        try
        {
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void doConnect()
    {
        try
        {
            url = url.concat(mainGui.getTxtDBName().getText());
            user = mainGui.getTxtUserName().getText();
            password = mainGui.getTxtPassWord().getText();

            propertyDB = new PropertyDB(driver, url, user, password);
            connection = daoUtils.getConnection(propertyDB);

            metaTables = getMetaTables();
            ListBinding.bindingMetaTable(metaTables, mainGui.getListTable(), mainGui.getPanelListTable());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<MetaTable> getMetaTables()
    {
        List<MetaTable> metaTableList = new ArrayList<MetaTable>();
        try
        {
            DatabaseMetaData metaData = connection.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = metaData.getTables(null, null, "%", types);
            tables = new ArrayList<String>();
            while (rs.next())
            {
                String tableName = rs.getString(3);
                tables.add(tableName); // 1: none 2: schema 3: table name 4: table type (TABLE, VIEW)
            }

            for (String table : tables)
            {
                ResultSet rsPrimaryKeys = metaData.getPrimaryKeys("", "", table);
                boolean flagPrimaryKey = false;
                String nameColumPrimaryKey = "";
                while (rsPrimaryKeys.next())
                {
                    flagPrimaryKey = true;
                    nameColumPrimaryKey = rsPrimaryKeys.getString("COLUMN_NAME");
                }
                if (!flagPrimaryKey)
                {
                    continue;
                }
                MetaTable metaTable = new MetaTable();
                metaTable.setNameTable(table);
                metaTable.setNamePrimaryKey(nameColumPrimaryKey);
                ResultSet rsTable = metaData.getColumns(null, null, table, "%");
                MetaColumn metaColumn = null;

                while (rsTable.next())
                {
                    metaColumn = new MetaColumn();
                    if (rsTable.getString(4).equals(nameColumPrimaryKey))
                    {
                        metaColumn.setFlagPrimaryKey(true);
                    }
                    metaColumn.setNameColumn(rsTable.getString(4));
                    metaColumn.setTypeData(rsTable.getString(6));
                    metaTable.addMetaColumns(metaColumn);
                    metaTable.setTypeDataNamePrimaryKey(metaColumn.getTypeDataPrimaryKey());
                }
                metaTableList.add(metaTable);
            }
            rs.close();
            return metaTableList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void changeTableListener()
    {
        int indexSelected = mainGui.getListTable().getSelectedIndex();
        TableBinding.bindingMetaColumn(metaTables.get(indexSelected).getMetaColumns(), mainGui.getTableColumn(), mainGui.getPanelListTable());
    }

    public void setOutput()
    {
        new FileChooserGui().show();
    }
}
