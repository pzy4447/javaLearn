package Swing;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

public class DialogDemo extends JPanel {

	JLabel label;
	JTabbedPane tabbedPane;
	ImageIcon customIcon;// 用户定制图标

	public DialogDemo() {
		super(new BorderLayout());
		tabbedPane = new JTabbedPane();
		label = new JLabel("click the button to create a dialog.");

		// 主面板布局
		setLayout(new BorderLayout());
		add(tabbedPane, BorderLayout.CENTER);
		add(label, BorderLayout.SOUTH);

		// 构造tabbedPane
		tabbedPane.addTab("SimpleModalDialogs", createSimpleModalDialogsPane());// 第一个面板
		tabbedPane.addTab("MoreDialogs", createMoreDialogsPane());// 第二个面板
		tabbedPane.addTab("IconDialogs", createIconDialogsPane());// 第三个面板
		tabbedPane.setSelectedIndex(2);
		// 构造label
		label.setHorizontalAlignment(JLabel.CENTER);// 居中显示
		// 初始化icon
		customIcon = new ImageIcon(
				"resources\\DialogDemo\\icon\\customIcon.png");
	}

	public JPanel createSimpleModalDialogsPane() {
		JPanel pane = new JPanel();// 整体的panel,包含4部分
		JLabel label = new JLabel("Some simple message dialogs");
		JPanel boxPanel = new JPanel();// 包含4个radioButtons
		ButtonGroup buttonGroup = new ButtonGroup();
		JButton button = new JButton("Show it");

		// 构造boxPanel
		boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));// 垂直分布boxlayout
		boxPanel.add(label);
		
		// 构造radioButtons
		String[][] radioButtonProperties = {
				{ "OK (in the L&F's words)", "default" },
				{ "Yes/No (in the L&F's words)", "yesno" },
				{ "Yes/No(in the programmer's words)", "yeahnah" },
				{ "Yes/No/Cancel(in the programmer's words)", "ync" } };// 二维数组，存储radioButton的名称和actionCommand

		JRadioButton[] radioButtons = new JRadioButton[radioButtonProperties.length];// 存储radioButton

		for (int i = 0; i < radioButtonProperties.length; i++) {
			JRadioButton radioButton = new JRadioButton(
					radioButtonProperties[i][0]);
			radioButton.setActionCommand(radioButtonProperties[i][1]);
			boxPanel.add(radioButton);
			buttonGroup.add(radioButton);
			radioButtons[i] = radioButton;
		}
		radioButtons[0].setSelected(true);// 选中第一个

		// 构造button
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				String actionCommand = buttonGroup.getSelection()
						.getActionCommand();
				// System.out.println("actionCommand is " + actionCommand);
				if (actionCommand.equals(radioButtonProperties[0][1])) // ok
				{
					setLabel("This is a plain message dialog");
					JOptionPane.showMessageDialog(null,
							"Eggs aren't supposed to be green.");
						
				} else if (actionCommand.equals(radioButtonProperties[1][1]))// yesno
				{
					setLabel("This is a confirm dialog with Yes/No options");
					JOptionPane.showConfirmDialog(null,
							"Would you like green eggs and ham?",
							"An Inane Question", JOptionPane.YES_NO_OPTION);
					
				} else if (actionCommand.equals(radioButtonProperties[2][1]))// "yeahnah"
				{
					setLabel("This is a Yes/No option dialog with your own options");
					Object[] options = { "Yes, please", "No way!" };
					JOptionPane.showOptionDialog(null,
							"Would you like green eggs and ham?",
							"A Silly Question", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);
					
				} else if (actionCommand.equals(radioButtonProperties[3][1]))// "ync"
				{
					setLabel("This is a Yes/No/Cancel option dialog with your own options");
					Object[] options = { "Yes, please", "No, thanks!",
							"No eggs, no ham!" };
					JOptionPane.showOptionDialog(null,
							"Would you like green eggs to go with that ham??",
							"A Silly Question",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);
				}
				return;
			}
		});

		pane.setLayout(new BorderLayout());
		pane.add(boxPanel, BorderLayout.CENTER);
		pane.add(button, BorderLayout.SOUTH);
		pane.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		return pane;
	}

	public JPanel createMoreDialogsPane() {
		JPanel pane = new JPanel();// 整体的panel,包含所有控件
		JLabel label = new JLabel("Some simple message dialogs");
		JPanel boxPanel = new JPanel();// 包含4个radioButtons
		ButtonGroup buttonGroup = new ButtonGroup();
		JButton button = new JButton("Show it");

		// 构造boxPanel
		boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));// 垂直分布boxlayout
		boxPanel.add(label);
		
		// 构造radioButtons
		String[][] radioButtonProperties = {
				{ "Pick one of several choices", "pickOne" },
				{ "Enter some text", "textField" },
				{ "Non-auto-closing dialog", "nonAutoClose" },
				{ "Input-validating dialog (with custom message area)",
						"customOption" }, { "Non-modal dialog", "nonModal" } };// 二维数组，存储radioButton的名称和actionCommand

		JRadioButton[] radioButtons = new JRadioButton[radioButtonProperties.length];// 存储radioButton

		for (int i = 0; i < radioButtonProperties.length; i++) {
			JRadioButton radioButton = new JRadioButton(
					radioButtonProperties[i][0]);
			radioButton.setActionCommand(radioButtonProperties[i][1]);
			boxPanel.add(radioButton);
			buttonGroup.add(radioButton);
			radioButtons[i] = radioButton;
		}
		radioButtons[0].setSelected(true);// 选中第一个

		// 构造button
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				String actionCommand = buttonGroup.getSelection()
						.getActionCommand();
				// System.out.println("actionCommand is " + actionCommand);
				if (actionCommand.equals(radioButtonProperties[0][1])) // pickone
				{
					setLabel("This is a input dialog with some options");
					Object[] options = { "ham", "spam", "yam" };
					JOptionPane.showInputDialog(null,
							"Complete the sentence:\n"
									+ "\"Green eggs and...\"",
							"Customized Dialog",
							JOptionPane.INFORMATION_MESSAGE, null, options,
							options[0]);
				} else if (actionCommand.equals(radioButtonProperties[1][1]))// textfield
				{
					setLabel("This is a input dialog with textField and init value");
					JOptionPane.showInputDialog("Complete the sentence:\n"
							+ "\"Green eggs and...\"", "ham");
				} else if (actionCommand.equals(radioButtonProperties[2][1]))// nonAutoClose
				{
					setLabel("This is a dialog that you can't close with 'exit' button");
					JOptionPane optionPane = new JOptionPane(
							"The only way to close this dialog is by\n"
									+ "pressing one of the following buttons.\n"
									+ "Do you understand?",
							JOptionPane.INFORMATION_MESSAGE,
							JOptionPane.YES_NO_OPTION);
					optionPane.createDialog(null, "nonAutoClose");
					final JDialog dialog = new JDialog();
					dialog.setTitle("Click a button");
					dialog.setModal(true);// 模态
					dialog.setContentPane(optionPane);
					// 当窗体被关闭时，禁止它被关闭
					dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
					dialog.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) {
							setLabel("Thwarted user attempt to close window.");
							System.out
									.println("Thwarted user attempt to close window.");
						}
					});
					// 检测按键事件，关闭窗体
					optionPane
							.addPropertyChangeListener(new PropertyChangeListener() {
								public void propertyChange(PropertyChangeEvent e) {
									String prop = e.getPropertyName();
									if (dialog.isVisible()
											&& (e.getSource() == optionPane)
											&& (JOptionPane.VALUE_PROPERTY
													.equals(prop))) {
										// If you were going to check something
										// before closing the window, you'd do
										// it here.
										dialog.setVisible(false);
									}
								}
							});

					dialog.pack();
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);

				} else if (actionCommand.equals(radioButtonProperties[3][1]))// customoption
				{
					setLabel("This is a input dialog that can verify your input");
					String expectedInput = "whisly";
					String input = JOptionPane
							.showInputDialog(
									"What was Dr. SEUSS's real last name?\n"
											+ "(The answer is " + expectedInput
											+ ")\n", "whisly");

					if (input.equals(expectedInput)) {
						setLabel("Congratulations!");
					} else {
						setLabel("Oh shit!");
					}
				} else if (actionCommand.equals(radioButtonProperties[4][1]))// nonmodal
				{
					setLabel("This is a nonmodal dialog");
					JDialog dialog = new JDialog();
					JPanel panel = new JPanel();
					JLabel label = new JLabel();
					JButton button = new JButton();

					// 构造panel
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
					panel.add(label);
					panel.add(button);

					// 构造label
					label.setText("<html><p align=center>"
							+ "This is a non-modal dialog.<br>"
							+ "You can have one or more of these up<br>"
							+ "and still use the main window.");
					label.setAlignmentX(CENTER_ALIGNMENT);
					// label.setHorizontalAlignment(JLabel.CENTER);

					// 构造button
					button.setText("Close");
					button.setAlignmentX(LEFT_ALIGNMENT);
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							dialog.setVisible(false);
							dialog.dispose();
						}
					});

					// 构造dialog
					dialog.setTitle("nonModalDialog");
					dialog.setContentPane(panel);
					dialog.setModal(false);
					dialog.pack();
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				}
				return;
			}
		});

		pane.setLayout(new BorderLayout());
		pane.add(boxPanel, BorderLayout.CENTER);
		pane.add(button, BorderLayout.SOUTH);
		pane.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		return pane;
	}

	public JPanel createIconDialogsPane() {
		JPanel pane = new JPanel();// 整体的panel,包含所有控件
		JPanel boxPanel = new JPanel();// 包含label与radioButtonsPanel
		JPanel radioButtonsPanel = new JPanel();// 包含所有radioButtons
		JLabel label = new JLabel(
				"Choose a icon, it will appears in the new dialog");
		ButtonGroup buttonGroup = new ButtonGroup();
		JButton button = new JButton("Show it");
		String[][] radioButtonProperties = { { "Plain(no icon)", "plain" },
				{ "Error icon", "error" },
				{ "Information icon", "information" },
				{ "Warnning icon", "warnning" },
				{ "Question icon", "question" }, { "Custon icon", "custon" } };// 二维数组，存储radioButton的名称和actionCommand
		JRadioButton[] radioButtons = new JRadioButton[radioButtonProperties.length];// 存储radioButton

		//构造label
		label.setAlignmentX(RIGHT_ALIGNMENT);
		
		// 构造radioButtonsPane
		int colNum = 2;
		radioButtonsPanel.setLayout(new GridLayout(
				radioButtonProperties.length / 2, colNum));

		// 构造radioButtons
		for (int i = 0; i < radioButtonProperties.length; i++) {
			JRadioButton radioButton = new JRadioButton(
					radioButtonProperties[i][0]);
			radioButton.setActionCommand(radioButtonProperties[i][1]);
			radioButtonsPanel.add(radioButton);
			buttonGroup.add(radioButton);
			radioButtons[i] = radioButton;
		}
		radioButtons[0].setSelected(true);// 选中第一个

		// 构造button
		button.setAlignmentX(CENTER_ALIGNMENT);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				String actionCommand = buttonGroup.getSelection()
						.getActionCommand();
				// System.out.println("actionCommand is " + actionCommand);
				if (actionCommand.equals(radioButtonProperties[0][1])) // plain
				{
					setLabel("this is a plain message dialog which has no icon");
					JOptionPane.showMessageDialog(null,
							"Eggs aren't supposed to be green.", actionCommand,
							JOptionPane.PLAIN_MESSAGE);
				} else if (actionCommand.equals(radioButtonProperties[1][1]))// error
				{
					setLabel("this is a error message dialog with a default icon");
					JOptionPane.showMessageDialog(null,
							"Eggs aren't supposed to be green.", actionCommand,
							JOptionPane.ERROR_MESSAGE);

				} else if (actionCommand.equals(radioButtonProperties[2][1]))// information
				{
					setLabel("this is a information message dialog with a default icon");
					JOptionPane.showMessageDialog(null,
							"Eggs aren't supposed to be green.", actionCommand,
							JOptionPane.INFORMATION_MESSAGE);

				} else if (actionCommand.equals(radioButtonProperties[3][1]))// warnning
				{
					setLabel("this is a warnning message dialog with a default icon");
					JOptionPane.showMessageDialog(null,
							"Eggs aren't supposed to be green.", actionCommand,
							JOptionPane.WARNING_MESSAGE);

				} else if (actionCommand.equals(radioButtonProperties[4][1]))// question
				{
					setLabel("this is a question message dialog with a default icon");
					JOptionPane.showMessageDialog(null,
							"Eggs aren't supposed to be green.", actionCommand,
							JOptionPane.QUESTION_MESSAGE);

				} else if (actionCommand.equals(radioButtonProperties[5][1]))// custom
				{
					setLabel("this is a plain message dialog with a custom icon");
					JOptionPane.showMessageDialog(null,
							"Eggs aren't supposed to be green.", actionCommand,
							JOptionPane.PLAIN_MESSAGE, customIcon);
				}
				return;
			}
		});
		
		// 构造boxpanel
		boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
		boxPanel.add(label);
		boxPanel.add(radioButtonsPanel);
		//构造panel
		pane.setLayout(new BorderLayout());
		pane.add(boxPanel, BorderLayout.CENTER);
		pane.add(button, BorderLayout.SOUTH);
		pane.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		return pane;
	}

	void setLabel(String newText) {
		label.setText(newText);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建窗体并指定标题
		JFrame frame = new JFrame("DialogDemo1");
		// 设置内容面板，根据需要进行修改
		frame.setContentPane(new DialogDemo());
		// 关闭窗体后退出程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 自动适配所有控件大小
		frame.pack();
		// 设置窗体位置在屏幕中央
		frame.setLocationRelativeTo(null);
		// 显示窗体
		frame.setVisible(true);
	}
}
