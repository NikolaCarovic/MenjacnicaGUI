package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;

import menjacnica.modeli.TabelaIzgled;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTable table;
	private JScrollPane scrollPane_1;
	private static JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmObrisiKurs;
	private JMenuItem mntmIzvrsiZamenu;
	private static MenjacnicaGUI frame = new MenjacnicaGUI();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
					frame.setSize(new Dimension(700, 450));
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							ugasiApl();
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setTitle("Menjacnica");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/money.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.EAST);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
	}
	public static void dodajKurs(String tekst) {
		textArea.setText(textArea.getText() + tekst + "\n");
	}
	
	public static void ugasiApl() {
		int odgovor = JOptionPane.showConfirmDialog(frame, "Da li zelite da izadjete iz programa?", "Zatvaranje",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (odgovor == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(140, 10));
			panel.setLayout(null);
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
			panel.add(getBtnNewButton_2());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setPreferredSize(new Dimension(10, 90));
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Dodaj kurs");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DodajKursGUI dodajkurs = new DodajKursGUI();
					dodajkurs.setVisible(true);
					dodajkurs.setLocationRelativeTo(null);
				}
			});
			btnNewButton.setBounds(10, 11, 120, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Obrisi kurs");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ObrisiKursGUI obrisiKurs = new ObrisiKursGUI();
					obrisiKurs.setVisible(true);
					obrisiKurs.setLocationRelativeTo(null);
				}
			});
			btnNewButton_1.setBounds(10, 45, 120, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Izvrsi zamenu");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzvrsiZamenuGUI izvrsiZamenu = new IzvrsiZamenuGUI();
					izvrsiZamenu.setVisible(true);
					izvrsiZamenu.setLocationRelativeTo(null);
				}
			});
			btnNewButton_2.setPreferredSize(new Dimension(110, 23));
			btnNewButton_2.setBounds(10, 80, 120, 23);
		}
		return btnNewButton_2;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new TabelaIzgled());
			
			addPopup(table, getPopupMenu());
		}
		return table;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTextArea_1());
		}
		return scrollPane_1;
	}
	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmNewMenuItem());
			mnFile.add(getMntmNewMenuItem_1());
			mnFile.add(getMntmNewMenuItem_2());
		}
		return mnFile;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Help");
			mnNewMenu.add(getMntmNewMenuItem_3());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Open");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String putanja = "";
					try {
						JFileChooser fc = new JFileChooser();
						int odgovor = fc.showOpenDialog(frame);
						if(odgovor == JFileChooser.APPROVE_OPTION){
							File file = fc.getSelectedFile();
							putanja = file.getAbsolutePath();
							textArea.append("Ucitan fajl " + putanja + '\n');
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, e.getMessage(), "Greska",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				}
			);
			mntmNewMenuItem.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
			mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("Save");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String fajl = "";
					try {
						JFileChooser fc = new JFileChooser();
						int odgovor = fc.showSaveDialog(frame);
						if (odgovor == JFileChooser.APPROVE_OPTION) {
							File file = fc.getSelectedFile();
							fajl = file.getAbsolutePath();
							textArea.append("Sacuvan fajl: " + fajl + "\n");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			mntmNewMenuItem_1.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
			mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("Exit");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ugasiApl();
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("About");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(frame, "Nikola Carovic, "
							+ "Druga godina, "
							+ "154/15");
							
				}
			});
		}
		return mntmNewMenuItem_3;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmObrisiKurs());
			popupMenu.add(getMntmIzvrsiZamenu());
		}
		return popupMenu;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DodajKursGUI dodajkurs = new DodajKursGUI();
					dodajkurs.setVisible(true);
					dodajkurs.setLocationRelativeTo(null);
				}
			});
		}
		return mntmDodajKurs;
	}
	private JMenuItem getMntmObrisiKurs() {
		if (mntmObrisiKurs == null) {
			mntmObrisiKurs = new JMenuItem("Obrisi kurs");
			mntmObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ObrisiKursGUI obrisiKurs = new ObrisiKursGUI();
					obrisiKurs.setVisible(true);
					obrisiKurs.setLocationRelativeTo(null);
				}
			});
		}
		return mntmObrisiKurs;
	}
	private JMenuItem getMntmIzvrsiZamenu() {
		if (mntmIzvrsiZamenu == null) {
			mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
			mntmIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzvrsiZamenuGUI izvrsiZamenu = new IzvrsiZamenuGUI();
					izvrsiZamenu.setVisible(true);
					izvrsiZamenu.setLocationRelativeTo(null);
				}
			});
		}
		return mntmIzvrsiZamenu;
	}
}
