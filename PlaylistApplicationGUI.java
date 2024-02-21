import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaylistApplicationGUI extends JFrame implements ActionListener {
    private CircularLinkedList playlist;
    private JTextArea playlistTextArea;

    public PlaylistApplicationGUI() {
        // Set up the JFrame
        setTitle("Song Playlist Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Create the playlist object
        playlist = new CircularLinkedList();

        // Create the playlist text area
        playlistTextArea = new JTextArea();
        playlistTextArea.setEditable(false);

        // Create the buttons
        JButton addButton = new JButton("Add Music");
        JButton removeButton = new JButton("Remove Music");
        JButton showButton = new JButton("Show Playlist");
        JButton nextButton = new JButton("Play Next");
        JButton prevButton = new JButton("Play Previous");
        JButton firstButton = new JButton("Play First");
        JButton lastButton = new JButton("Play Last");
        JButton searchButton = new JButton("Search Music");

        // Add action listeners to the buttons
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        showButton.addActionListener(this);
        nextButton.addActionListener(this);
        prevButton.addActionListener(this);
        firstButton.addActionListener(this);
        lastButton.addActionListener(this);
        searchButton.addActionListener(this);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(showButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(firstButton);
        buttonPanel.add(lastButton);
        buttonPanel.add(searchButton);

        // Add components to the JFrame
        add(new JScrollPane(playlistTextArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlaylistApplicationGUI app = new PlaylistApplicationGUI();

            app.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Add Music":
                playlist.insert();
                break;
            case "Remove Music":
                playlist.deleteElement();
                break;
            case "Show Playlist":
                playlistTextArea.setText("");
                playlist.show();
                break;
            case "Play Next":
                playlist.nextNode();
                break;
            case "Play Previous":
                playlist.prevNode();
                break;
            case "Play First":
                playlist.playFirst();
                break;
            case "Play Last":
                playlist.playLast();
                break;
            case "Search Music":
                playlist.specificData();
                break;
        }
    }

}