package com.techlab.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.techlab.model.GameFrameBoardHandler;
import com.techlab.model.Game;

public class GameMainFrame extends JFrame {
	JButton[] buttons = new JButton[9];
	JLabel titleName;

	public GameMainFrame(Game game) {
		JPanel buttonPanel = new JPanel();
		JPanel titlePanel = new JPanel();
		GameFrameBoardHandler boardHandler = new GameFrameBoardHandler(this, game);

		titleName = new JLabel(game.getCurrentPlayer().getpName() + "'s Turn");
		titleName.setBackground(new Color(0, 0, 0));
		titleName.setForeground(new Color(255, 0, 0));
		titleName.setFont(new Font("Arial", Font.BOLD, 60));
		titleName.setHorizontalAlignment(JLabel.CENTER);
		titleName.setOpaque(true);

		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 500, 75);
		titlePanel.add(titleName);
		this.add(titlePanel, BorderLayout.NORTH);

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(Integer.toString(i));
			buttonPanel.add(buttons[i]);
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(boardHandler);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 60));
			buttons[i].setBackground(Color.WHITE);
		}

		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setBackground(new Color(0, 255, 0));
		this.add(buttonPanel);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JButton[] getButtons() {
		return buttons;
	}

	public void setTitleName(String name) {
		this.titleName.setText(name + "'s Turn");
	}

	public void setButtons(int cellLoc, String mark) {
		this.buttons[cellLoc].setText(mark);
	}

	public void setResult(String name, Boolean result) {
		if (!result) {
			this.titleName.setText("Game Draws");
			disableButtons();
			playAgain();
		} else {
			this.titleName.setText(name + " Wins");
			disableButtons();
			playAgain();
		}
	}

	public void disableButtons() {
		for (int i = 0; i < buttons.length; i++) {
			this.buttons[i].setEnabled(false);
		}
	}

	public void playAgain() {
		int response = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			new GameLoginFrame();
			dispose();
		} else {
			System.exit(0);
		}
	}
}
