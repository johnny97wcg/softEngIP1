package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Puzzle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import controller.ResetController;
import controller.SelectController;

public class SlidingPuzzleApp extends JFrame {
	
	Puzzle puzzle;

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	PuzzleView puzzleView;
	
	public PuzzleView getPuzzleView() { return puzzleView; }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlidingPuzzleApp frame = new SlidingPuzzleApp(new Puzzle());
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
	public SlidingPuzzleApp(Puzzle puzzle) {
		setTitle("SlidingPuzzleApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	
		puzzleView = new PuzzleView(puzzle);
		puzzleView.setBorder(new LineBorder(new Color(0, 0, 0)));
		puzzleView.setBackground(Color.GRAY);
		puzzleView.setSize(new Dimension(400, 500));
		puzzleView.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println(String.valueOf(e.getPoint()));
				new SelectController(SlidingPuzzleApp.this, puzzle).select(e.getX(), e.getY());
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetController(SlidingPuzzleApp.this, puzzle).reset();
			}
		});
		
		JButton btnUp = new JButton("^");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnLeft = new JButton("<");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnRight = new JButton(">");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnDown = new JButton("V");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblMoves = new JLabel("Moves:");
		int move = 0;
		JLabel label = new JLabel(String.valueOf(move));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(puzzleView, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(38)
									.addComponent(btnUp))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLeft)
									.addGap(33)
									.addComponent(btnRight)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(btnReset)
									.addComponent(btnDown))
								.addGap(15)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMoves)
							.addGap(18)
							.addComponent(label)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(puzzleView, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoves)
								.addComponent(label))
							.addGap(189)
							.addComponent(btnUp)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRight)
								.addComponent(btnLeft))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDown)
							.addPreferredGap(ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
							.addComponent(btnReset)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public SlidingPuzzleApp() {
		this(new Puzzle());
	}
}
