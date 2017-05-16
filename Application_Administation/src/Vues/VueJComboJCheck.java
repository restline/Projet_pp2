package Vues;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class VueJComboJCheck extends DefaultTableCellRenderer
{
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("rawtypes")
	public Component getComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column)
	{
		if(value instanceof JComboBox) //si la valeur est un JComboBox
		{
			return (JComboBox) value;
		}
		if(value instanceof Boolean) //si la valeur esr boolean
		{
			JCheckBox cb = new JCheckBox();
            cb.setSelected(((Boolean) value).booleanValue());
            return cb;
		}
		if(value instanceof JCheckBox) //si la valeur est un JCheckbox
		{
			 return (JCheckBox) value;
		}
		return new JTextField(value.toString());
	}
}
