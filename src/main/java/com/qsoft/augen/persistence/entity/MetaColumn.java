package com.qsoft.augen.persistence.entity;

public class MetaColumn
{
    public static String NAME_COLUMN = "nameColumn";
    public static String TYPE_DATA = "typeData";

    private boolean flagPrimaryKey = false;
    private String nameColumn;
    private String typeData;
    private String nameColumnFirstUpper;
    private String typeDataFirstUpper;
    private String typeDataPrimaryKey;

    public MetaColumn()
    {
    }

    public MetaColumn(String typeData, String nameColumn, boolean flagPrimakey)
    {
        this.flagPrimaryKey = flagPrimakey;
        this.typeData = typeData;
        this.nameColumn = nameColumn;
        setNameColumnFirstUpper("");
        setTypeDataFirstUpper("");
        setTypeDataPrimarykey();
    }

    private void setTypeDataPrimarykey()
    {
        if (this.flagPrimaryKey)
        {
            if (compare(typeData,"int"))
            {
                typeDataPrimaryKey = "Integer";
            }
            if (compare(typeData, "int8") || compare(typeData, "long") || compare(typeData, "bigserial") || compare(typeData, "bigint"))
            {
                typeDataPrimaryKey = "Long";
            }
        }
    }

    public void setTypeData(String typeData)
    {
        this.typeData = convertTypeData(typeData);
        setTypeDataFirstUpper(nameColumn);
        setTypeDataPrimarykey();
    }

    public String getTypeData()
    {
        return typeData;
    }

    public void setNameColumn(String nameColumn)
    {
        this.nameColumn = nameColumn;
        setNameColumnFirstUpper(typeData);
    }

    public String getNameColumn()
    {
        return nameColumn;
    }

    public void setFlagPrimaryKey(boolean flagPrimaryKey)
    {
        this.flagPrimaryKey = flagPrimaryKey;
    }

    public boolean isFlagPrimaryKey()
    {
        return flagPrimaryKey;
    }

    public void setTypeDataFirstUpper(String typeDataFirstUpper)
    {
        char[] stringArray = this.typeData.toCharArray();
        stringArray[0] = Character.toUpperCase(stringArray[0]);
        this.typeDataFirstUpper = new String(stringArray);
    }

    public String getTypeDataFirstUpper()
    {
        return typeDataFirstUpper;
    }

    public void setNameColumnFirstUpper(String nameColumnFirstUpper)
    {
        char[] stringArray = this.nameColumn.toCharArray();
        stringArray[0] = Character.toUpperCase(stringArray[0]);
        this.nameColumnFirstUpper = new String(stringArray);
    }

    public String getNameColumnFirstUpper()
    {
        return nameColumnFirstUpper;
    }

    public void setTypeDataPrimaryKey(String typeDataPrimaryKey)
    {
        this.typeDataPrimaryKey = typeDataPrimaryKey;
    }

    public String getTypeDataPrimaryKey()
    {
        return typeDataPrimaryKey;
    }

    public boolean compare(String string, String otherString)
    {
        if (string.toLowerCase().equals(otherString.toLowerCase()))
        {
            return true;
        }
        return false;
    }

    public String convertTypeData(String typeData)
    {
        if (compare(typeData, "INT") || compare(typeData, "numeric"))
        {
            return "int";
        }
        if (compare(typeData, "VARCHAR") || compare(typeData, "TEXT") || compare(typeData, "bpchar"))
        {
            return "String";
        }
        if (compare(typeData, "BIGINT") || compare(typeData, "int8") || compare(typeData, "bigserial") || compare(typeData, "int4"))
        {
            return "Long";
        }
        if (compare(typeData, "BOOLEAN") || compare(typeData, "bool"))
        {
            return "boolean";
        }
        if (compare(typeData, "DOUBLE"))
        {
            return "double";
        }
        if (compare(typeData, "DATE") || compare(typeData, "DATETIME") || compare(typeData, "timestamp"))
        {
            return "Date";
        }
        return typeData;
    }
}
