package com.qsoft.augen.ui.common;

import com.qsoft.augen.persistence.entity.MetaTable;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.SwingBindings;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: anhnt
 * Date: 8/30/13
 * Time: 10:53 AM
 */
public class ListBinding
{
    public static Map<String, JListBinding> bindMap = new HashMap<String, JListBinding>();

    public static void bindingMetaTable(List<MetaTable> metaTableList, JList list, JScrollPane panel)
    {
        unbinding(list, panel);
        JListBinding jListBinding = SwingBindings.createJListBinding(AutoBinding.UpdateStrategy.READ_WRITE, metaTableList, list);
        ELProperty nameTable = ELProperty.create("${nameTable}");
        jListBinding.setDetailBinding(nameTable);
        jListBinding.bind();
        bindMap.put(panel.hashCode() + "." + list.hashCode(), jListBinding);
    }

    //----------------- unbinding-------------------------------
    public static void unbinding(JList list, JScrollPane panel)
    {
        String key = list.hashCode() + "." + panel.hashCode();
        if (bindMap.containsKey(key))
        {
            bindMap.get(key).unbind();
            bindMap.remove(bindMap.get(key));
        }
    }
}
