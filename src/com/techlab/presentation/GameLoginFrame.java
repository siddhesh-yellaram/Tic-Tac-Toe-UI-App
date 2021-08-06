package com.techlab.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.techlab.model.GameLoginFrameHandler;

public class GameLoginFrame extends JFrame {
	JTextField playerName1, playerName2;

	public GameLoginFrame() {
		JPanel titlePanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		JLabel titleName = new JLabel("Tic Tac Toe");
		titleName.setBackground(Color.BLACK);
		titleName.setForeground(Color.RED);
		titleName.setFont(new Font("Arial", Font.BOLD, 60));
		titleName.setHorizontalAlignment(JLabel.CENTER);
		titleName.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 500, 75);
		titlePanel.add(titleName);
		this.add(titlePanel, BorderLayout.NORTH);

		playerName1 = new JTextField();
		playerName1.setBounds(150, 100, 200, 50);
		playerName1.setFont(new Font("Arial",Font.BOLD,25));
		this.add(playerName1);
		JLabel labelPlayer1 = new JLabel("Player 1");
		labelPlayer1.setFont(new Font("Arial", Font.BOLD, 25));
		labelPlayer1.setBounds(30, 100, 200, 50);
		this.add(labelPlayer1);

		playerName2 = new JTextField();
		playerName2.setBounds(150, 180, 200, 50);
		playerName2.setFont(new Font("Arial",Font.BOLD,25));
		this.add(playerName2);
		JLabel labelPlayer2 = new JLabel("Player 2");
		labelPlayer2.setFont(new Font("Arial", Font.BOLD, 25));
		labelPlayer2.setBounds(30, 180, 200, 50);
		this.add(labelPlayer2);

		JButton startGameButton = new JButton("Start Game");
		startGameButton.setBounds(180, 250, 150, 60);
		startGameButton.setFont(new Font("Arial",Font.BOLD,20));
		startGameButton.setBackground(Color.GREEN);
		buttonPanel.setBackground(new Color(173, 216, 230));
		this.add(startGameButton);
		startGameButton.addActionListener(new GameLoginFrameHandler(this));

		this.add(buttonPanel);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);

	}

	public String getPlayerName1() {
		return playerName1.getText();
	}

	public String getPlayerName2() {
		return playerName2.getText();
	}
}
