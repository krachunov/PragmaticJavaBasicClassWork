package Lecture10ExampleDictionary;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import java.util.*;

@SuppressWarnings("serial")
public class DictionaryTableModel extends AbstractTableModel {
	private static final int COLUNS_COUNT = 2;
	private List<WordEntity> wordEntites;

	@Override
	public int getColumnCount() {
		return (wordEntites != null ? wordEntites.size() : 0);
	}

	@Override
	public int getRowCount() {
		return COLUNS_COUNT;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		WordEntity wordEntity = this.wordEntites.get(rowIndex);
		if (columnIndex == 0) {
			return wordEntity.getWord();
		} else {

			return wordEntity.getTranslation();
		}
	}

	public void setWordEntrys(List<WordEntity> list) {
		wordEntites = list;
		fireTableDataChanged();
	}

	public WordEntity getWordEntity(int index) {
		return wordEntites.get(index);
	}

}
