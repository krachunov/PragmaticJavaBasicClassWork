package Lecture10ExampleDictionary.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Lecture10ExampleDictionary.Dictionary;
import Lecture10ExampleDictionary.DictionaryTableModel;
import Lecture10ExampleDictionary.WordEntity;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DictionaryUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearchWord;
	private JTable table;
	private DictionaryTableModel tabelMOdel;
	private Dictionary dictionary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DictionaryUI frame = new DictionaryUI();
					// frame.load();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DictionaryUI() {
		dictionary = new Dictionary();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldSearchWord = new JTextField();
		textFieldSearchWord.setBounds(37, 11, 187, 20);
		contentPane.add(textFieldSearchWord);
		textFieldSearchWord.setColumns(10);

		JButton btnSearchWord = new JButton("SearchWord");
		btnSearchWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchWord();
			}
		});
		btnSearchWord.setBounds(255, 10, 89, 23);
		contentPane.add(btnSearchWord);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 48, 294, 203);
		contentPane.add(scrollPane);

		tabelMOdel = new DictionaryTableModel();
		table = new JTable(tabelMOdel);
		scrollPane.setViewportView(table);

		JButton btnAddWord = new JButton("Add word");
		btnAddWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWord();
			}
		});
		btnAddWord.setBounds(335, 57, 89, 23);
		contentPane.add(btnAddWord);

		JButton btnNewButton = new JButton("delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteWord();
			}
		});
		btnNewButton.setBounds(345, 112, 89, 23);
		contentPane.add(btnNewButton);
	}

	public void load() {
		dictionary.load();
		tabelMOdel.setWordEntrys(dictionary.getSortedWordEntities());
	}

	public void addWord() {
		AddWordDialog dialog = new AddWordDialog();
		dialog.setModal(true);
		dialog.setVisible(true);

		WordEntity wordEntity = dialog.getWordEntity();
		if (wordEntity != null) {
			dictionary.addEntity(wordEntity);
			dictionary.save();
			tabelMOdel.setWordEntrys(dictionary.getSortedWordEntities());
		}
	}

	public void deleteWord() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			String word = (String) table.getModel().getValueAt(selectedRow, 0);
			dictionary.deleteWordEntry(word);
			dictionary.save();
			tabelMOdel.setWordEntrys(dictionary.getSortedWordEntities());
		}
	}
	private void searchWord() {
		String word = textFieldSearchWord.getText().trim();
		if(word.length() > 0) {
			WordEntity wordEntity = dictionary.searchWord(word);
			if(wordEntity != null) {
				JOptionPane.showMessageDialog(this,
						"Translation of " + wordEntity.getWord() + " is " + wordEntity.getTranslation(),
						"Translation",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this,
						"Unable to find word: " + word,
						"Translation",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
