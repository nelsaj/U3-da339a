package controller;

import view.ButtonType;
import view.CustomCakeFrame;
import view.MainFrame;

import java.lang.reflect.Array;
import java.util.Arrays;

import model.*;

/**
 * Klass som hanterar logiken i applikationen same kommunikationen mellan model- och view-klasser.
 * 
 * Ser till att lämpliga metoder exekveras när användare trycker på knappar och andra element i 
 * GUI:et.
 * 
 * @author Nelly Sajland, Elliot Collins
 */
public class Controller {
    private MainFrame view;
    private CustomCakeFrame newCakeType;
    private ButtonType currentLeftMenu = ButtonType.NoChoice;
    private Cake[] cakes;
    private Order[] previousOrders;
    private Order currentOrder;
    private PerUnitItem[] perUnitItems;

    /**
     * Konstruktor som skapar en ny instans av Controller.
     * 
     * Initierar en MainFrame (alltså gränssnittet), hårdkodade kakor och bakverk, och både nuvarande 
     * och föregående beställningar. Dessutom diverse lämpliga enable och disable för knappar.
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    public Controller() {
        view = new MainFrame(1000, 500, this);
        previousOrders = new Order[0];
        currentOrder = new Order(previousOrders.length + 1);
        loadInitialCakes();
        loadInitialPerUnitItems();

        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }


    /**
     * Lägger till 3 fördefinerade tårtor.
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    private void loadInitialCakes(){
        this.cakes = new Cake[3];
        
        cakes[0] = new Cake(new Filling[]{Filling.Choclate, Filling.Coconut}, 1, "CocoLoco");
        cakes[1] = new Cake(new Filling[]{Filling.Strawberry, Filling.MixedBerries}, 2, "Berry good");
        cakes[2] = new Cake(new Filling[]{Filling.Unknown, Filling.Unknown}, 3, "DONT TRY THIS PLEASE HELP");
    }
    /**
     * Lägger till 2 fördefinerade bakverk.
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    private void loadInitialPerUnitItems() {
        this.perUnitItems = new PerUnitItem[2];

        perUnitItems[0] = new PerUnitItem(20, "Kanelbulle");
        perUnitItems[1] = new PerUnitItem(10, "Chokladboll");
    }
    
    
    //This method is called by class MinFrame when a button in teh GUI is pressed
    /**
     * Anropa metoder beroende på vilken knapp som klickades.
     * 
     * @param button typen av knapp
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    public void buttonPressed(ButtonType button){

        switch (button) {
            case Add:
                addItemToOrder(view.getSelectionLeftPanel());
                break;

            case Cake: 
                setToCakeMenu();
                break;

            case PerUnitItem:
                setToPerUnitItemMenu();
                break;

            case MakeCake:
                addNewCake();
                break;

            case OrderHistory:
                setToOrderHistoryMenu();
                break;

            case Order:
                placeOrder();
                break;

            case ViewOrder:
                viewSelectedOrder(view.getSelectionLeftPanel());
                break;
        }
    }
    
    /**
     * Lägger till en tårta/bakverk till beställningen.
     * 
     * @param selectionIndex tillhörande index i listan
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    public void addItemToOrder(int selectionIndex) {
        if (selectionIndex != -1){ // if something is selected in the left menu list
            switch (currentLeftMenu) { //This might need to change depending on architecture
                case Cake:
                    currentOrder.addProduct(cakes[selectionIndex]);
                    break;
                case PerUnitItem:
                    currentOrder.addProduct(perUnitItems[selectionIndex]);
                    break;
            }
            
            setCurrentOrderRightPanel();            
        }

    }

    /**
     * Visar information om en selekterad beställning.
     * 
     * @param selectionIndex tillhörande index i listan
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    public void viewSelectedOrder(int selectionIndex){
        System.out.println("Index selection left panel: " + selectionIndex); //for test purposes  - remove when not needed

        if ((selectionIndex != -1) && currentLeftMenu==ButtonType.OrderHistory){
            String[] order = new String[previousOrders[selectionIndex].getPurchases().length + 1];
            order[0] = "Order " + previousOrders[selectionIndex].getId();
            
            for (int i = 0; i < previousOrders[selectionIndex].getPurchases().length; i++) {
                order[i + 1] = 
                previousOrders[selectionIndex].getPurchases()[i].getName() + " " +
                previousOrders[selectionIndex].getPurchases()[i].getPrice();
            }

            view.populateRightPanel(order); //update left panel with order details - this takes a shortcut in updating the entire information in the panel not just adds to the end
            view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(previousOrders[selectionIndex].getTotalPrice())); //set the text to show cost of current order
        }
    }


    /**
     * Visar tårta menyn och ändrar vänsta och högra panelen enlighetsamt.
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    public void setToCakeMenu() {
        currentLeftMenu = ButtonType.Cake;
        String[] cakeMenuString = new String[cakes.length];
        
        for (int i = 0; i < cakes.length; i++) {
            cakeMenuString[i] = cakes[i].toString();    
        }
        view.populateLeftPanel(cakeMenuString);
        
        setCurrentOrderRightPanel();

        view.enableAllButtons();
        view.disableCakeMenuButton();
        view.disableViewSelectedOrderButton();
    }


    /**
     * Visar bakverk menyn och ändrar vänsta och högra panelen enlighetsamt.
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    public void setToPerUnitItemMenu() {
        currentLeftMenu = ButtonType.PerUnitItem;
        String[] perUnitItemMenuString = new String[perUnitItems.length];
        for (int i = 0; i < perUnitItems.length; i++) {
            perUnitItemMenuString[i] = perUnitItems[i].toString();    
        }
        view.populateLeftPanel(perUnitItemMenuString);

        setCurrentOrderRightPanel();
        view.enableAllButtons();
        view.disablePerUnitItemMenuButton();
        view.disableViewSelectedOrderButton();
    }

    /**
     * Ändrar högra panelen till att visa nuvarande order, återanvänds för vissa vyer.
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    private void setCurrentOrderRightPanel () {
        String[] orderPurchasesStrings = new String[currentOrder.getPurchases().length];
        for (int i = 0; i < currentOrder.getPurchases().length; i++) {
            orderPurchasesStrings[i] = currentOrder.getPurchases()[i].toString();
        }
        view.populateRightPanel(orderPurchasesStrings); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(currentOrder.getTotalPrice())); //set the text to show cost of current order
    }

    /**
     * Visar beställningshistorik menyn och ändrar vänsta och högra panelen enlighetsamt.
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    public void setToOrderHistoryMenu() {
        currentLeftMenu = ButtonType.OrderHistory;
        view.clearRightPanel();
        String[] orderHistoryMenuString = new String[previousOrders.length];
        for (int i = 0; i < previousOrders.length; i++) {
            orderHistoryMenuString[i] = previousOrders[i].toString();
        }

        view.populateLeftPanel(orderHistoryMenuString);
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableOrderButton();
    }

    //Används inte
    public void addNewCake() {
        newCakeType = new CustomCakeFrame(this);
        //For grade VG: Add more code to save the new cake type and update menu,
        view.enableAllButtons();
    }

    /**
     * Gör en beställning, lägger till den beställningen i historik arrayen och tömmer nuvarande.
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    public void placeOrder() {
        Order[] newPreviousOrders = new Order[previousOrders.length + 1];
        for (int i = 0; i < previousOrders.length; i++) {
            newPreviousOrders[i] = previousOrders[i];
        } 
        newPreviousOrders[previousOrders.length] = currentOrder;
        previousOrders = newPreviousOrders;
        currentOrder = new Order(newPreviousOrders.length + 1);
        view.clearRightPanel(); //Removes information from right panel in GUI
        view.setTextCostLabelRightPanel("TOTAL COST: 0");
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }


}
