import java.util.Scanner;

class Node {
    String data;
    Node next;
    Node prev;

    public Node(String data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

class CircularLinkedList {
    private Node head;
    private Node current;

    public void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Music Name:");
        String musicName = scanner.nextLine();

        Node newNode = new Node(musicName);
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = current = newNode;
            return;
        }

        Node last = head.prev;
        newNode.prev = last;
        last.next = newNode;
        newNode.next = head;
        head.prev = newNode;
    }

    public void deleteElement() {
        if (head == null) {
            System.out.println("No Music is there to delete!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Music Name to delete:");
        String musicName = scanner.nextLine();

        Node ptr = head;
        do {
            if (ptr.next == ptr && ptr.data.equals(musicName)) {
                System.out.println("One file deleted! Playlist is Empty Now!");
                head = null;
                return;
            } else if (ptr.data.equals(musicName)) {
                Node prev = ptr.prev;
                Node next = ptr.next;
                prev.next = next;
                next.prev = prev;
                if (ptr == head) {
                    head = next;
                }
                System.out.println("Music deleted!");
                return;
            }
            ptr = ptr.next;
        } while (ptr != head);

        System.out.println("No Music file is there!");
    }

    public void show() {
        if (head == null) {
            System.out.println("Playlist is Empty!");
            return;
        }

        Node showPtr = head;
        System.out.println("\nDisplaying Playlist:");
        int i = 1;
        do {
            System.out.println("Song " + i + " : " + showPtr.data);
            i++;
            showPtr = showPtr.next;
        } while (showPtr != head);
    }

    public void nextNode() {
        if (head == null) {
            System.out.println("No songs in the playlist!");
        } else {
            current = current.next;
            if (current == head) {
                System.out.println("Playing Next Song: " + current.data);
            } else {
                System.out.println("Playing Next Song: " + current.next.data);
            }
        }
    }

    public void prevNode() {
        if (head == null) {
            System.out.println("No songs in the playlist!");
        } else {
            current = current.prev;
            if (current == head) {
                System.out.println("Playing Previous Song: " + current.data);
            } else {
                System.out.println("Playing Previous Song: " + current.prev.data);
            }
        }
    }

    public void playFirst() {
        if (head == null) {
            System.out.println("No songs in Playlist!");
        } else {
            current = head;
            System.out.println("Playing First Song: " + current.data);
        }
    }

    public void playLast() {
        if (head == null) {
            System.out.println("No songs in Playlist!");
        } else {
            current = head.prev;
            System.out.println("Playing Last Song: " + current.data);
        }
    }

    public void specificData() {
        if (head == null) {
            System.out.println("No music is there to be searched!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Music Name to search:");
        String musicName = scanner.nextLine();

        Node ptr = head;
        do {
            if (ptr.data.equals(musicName)) {
                System.out.println("Music Found!");
                System.out.println("Music Name: " + ptr.data);
                return;
            }
            ptr = ptr.next;
        } while (ptr != head);

        System.out.println("There is no Music file with this name!");
    }
}

public class PlaylistApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        CircularLinkedList playlist = new CircularLinkedList();

        do {
            System.out.println("\n-----Song Playlist Application-----");
            System.out.println("1. Add Music");
            System.out.println("2. Remove Music");
            System.out.println("3. Show Playlist");
            System.out.println("4. Play next file");
            System.out.println("5. Play previous file");
            System.out.println("6. Play first file");
            System.out.println("7. Play Last file");
            System.out.println("8. Search Music");
            System.out.println("9. Exit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

                            switch (choice) {
                                case 1:
                                    playlist.insert();
                                    break;
                                case 2:
                                    playlist.deleteElement();
                                    break;
                                case 3:
                                    playlist.show();
                                    break;
                                case 4:
                                    playlist.nextNode();
                                    break;
                                case 5:
                                playlist.prevNode();
                                break;
                                case 6:
                                    playlist.playFirst();
                                    break;
                                case 7:
                                    playlist.playLast();
                                    break;
                                case 8:
                                    playlist.specificData();
                                    break;

                                case 9:
                                    System.out.println("Exiting the program...");
                                    break;

                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        } while (choice != 9);

                        scanner.close();
                    }
                }