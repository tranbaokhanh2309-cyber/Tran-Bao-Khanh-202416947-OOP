package hust.soict.dsai.aims;

import java.util.Collections;
import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initStore();
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        Book book1 = new Book();
        book1.setTitle("Java Programming");
        book1.setCategory("Education");
        book1.setCost(29.99f);
        book1.addAuthor("Herbert Schildt");
        store.addMedia(book1);

        CompactDisc cd1 = new CompactDisc();
        cd1.setTitle("Thriller");
        cd1.setCategory("Pop");
        cd1.setArtist("Michael Jackson");
        cd1.setCost(15.0f);
        cd1.addTrack(new Track("Wanna Be Startin' Somethin'", 363));
        cd1.addTrack(new Track("Thriller", 357));
        store.addMedia(cd1);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    private static void viewStore() {
        System.out.println("Items in store:");
        for (Media media : store.getItemsInStore()) {
            System.out.println(media.toString());
        }
        while (true) {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    viewCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    private static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(store.getItemsInStore(), title);
        if (media != null) {
            System.out.println(media.toString());
            while (true) {
                mediaDetailsMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        System.out.println("Total media in cart: " + cart.getItemsOrdered().size());
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media is not playable.");
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    private static void addMediaToCart() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(store.getItemsInStore(), title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Total media in cart: " + cart.getItemsOrdered().size());
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void playMedia() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(store.getItemsInStore(), title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else if (media != null) {
            System.out.println("This media is not playable.");
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void updateStore() {
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            // Simplified: only adding a DVD for now or ask for type
            System.out.println("Enter type (1-DVD, 2-CD, 3-Book): ");
            int type = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter category: ");
            String category = scanner.nextLine();
            System.out.print("Enter cost: ");
            float cost = scanner.nextFloat();
            scanner.nextLine();

            if (type == 1) {
                store.addMedia(new DigitalVideoDisc(title, category, cost));
            } else if (type == 2) {
                CompactDisc cd = new CompactDisc();
                cd.setTitle(title);
                cd.setCategory(category);
                cd.setCost(cost);
                store.addMedia(cd);
            } else if (type == 3) {
                Book book = new Book();
                book.setTitle(title);
                book.setCategory(category);
                book.setCost(cost);
                store.addMedia(book);
            }
        } else if (choice == 2) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            Media media = findMediaByTitle(store.getItemsInStore(), title);
            if (media != null) {
                store.removeMedia(media);
            } else {
                System.out.println("Media not found.");
            }
        }
    }

    private static void viewCart() {
        cart.print();
        while (true) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    filterMediaInCart();
                    break;
                case 2:
                    sortMediaInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    System.out.println("Order placed. Cart cleared.");
                    cart.getItemsOrdered().clear();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    private static void filterMediaInCart() {
        System.out.println("Filter by: 1-ID, 2-Title");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            cart.search(id);
        } else if (choice == 2) {
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            cart.search(title);
        }
    }

    private static void sortMediaInCart() {
        System.out.println("Sort by: 1-Title, 2-Cost");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
        } else if (choice == 2) {
            Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
        }
        cart.print();
    }

    private static void removeMediaFromCart() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(cart.getItemsOrdered(), title);
        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void playMediaInCart() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(cart.getItemsOrdered(), title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else if (media != null) {
            System.out.println("This media is not playable.");
        } else {
            System.out.println("Media not found.");
        }
    }

    private static Media findMediaByTitle(java.util.List<Media> list, String title) {
        for (Media media : list) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }
}
