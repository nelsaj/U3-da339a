package controller;

import view.ButtonType;
import view.CustomCakeFrame;
import view.MainFrame;

import java.lang.reflect.Array;
import java.util.Arrays;

import model.*;

public class Controller {
    private MainFrame view;
    private CustomCakeFrame newCakeType;
    private ButtonType currentLeftMenu = ButtonType.NoChoice;
    private Cake[] cakes;
    private Order[] previousOrders;
    private int totalPrice;
    private Order currentOrder;
    private PerUnitItem[] perUnitItems;
    private int nbrOfOrders = 0; // for test purposes only



    private String [] cakeMenuString; // for test purposes only
    private String [] perUnitItemMenuString; // for test purposes only
    private String [] orderHistoryMenuString; // for test purposes only
    private String [] order1Simulation; // for test purposes only
    private String [] currentOrderArray; // for test purposes only
    private double costCurrentOrder = 0; // for test purposes only

    public Controller() {
        view = new MainFrame(1000, 500, this);
        currentOrder = new Order();
        previousOrders = new Order[0];
        loadInitialCakes();
        loadInitialPerUnitItems();

        loadStringTestValues(); //for test purposes - remove when not needed more
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }
    
    //This method is only used for test purposes - remove when no longer needed
    private void loadStringTestValues() {
        cakeMenuString = new String[10];
        perUnitItemMenuString = new String[10];
        orderHistoryMenuString = new String[10];
        order1Simulation = new String[10];
        currentOrderArray = new String[10];

        // cakeMenuString[0] = "tårta0, storlek: 4 bitar, topping1, topping2, Pris0";
        // cakeMenuString[1] = "tårta1, storlek: 6 bitar, topping1, topping3, Pris1";
        // cakeMenuString[2] = "tårta2, storlek: 4 bitar, topping1, topping2, Pris2";
        // cakeMenuString[3] = "tårta3, storlek: 12 bitar,topping1, topping3, Pris3";

        // perUnitItemMenuString[0] = "vetebulle, Pris11";
        // perUnitItemMenuString[1] = "pepparkaka, Pris22";

        // orderHistoryMenuString[0] = "order1: kostnad:100";
        // orderHistoryMenuString[1] = "order2: kostand:200";

        // order1Simulation[0] = "Order 1";
        // order1Simulation[1] = "tårta1 Pris1";
        // order1Simulation[2] = "tårta2 Pris2";
        // order1Simulation[3] = "vetebulle Pris11";

    }


    private void loadInitialCakes(){
        this.cakes = new Cake[3];
        
        cakes[0] = new Cake(new Filling[]{Filling.Choclate, Filling.Coconut}, 1, "CocoLoco");
        cakes[1] = new Cake(new Filling[]{Filling.Strawberry, Filling.MixedBerries}, 2, "Berry good");
        cakes[2] = new Cake(new Filling[]{Filling.Unknown, Filling.Unknown}, 3, "DONT TRY THIS PLEASE HELP");
        
    }
    private void loadInitialPerUnitItems() {
        this.perUnitItems = new PerUnitItem[2];

        perUnitItems[0] = new PerUnitItem(20, "Kanelbulle");
        perUnitItems[1] = new PerUnitItem(10, "Chokladboll");
    }
    
    
    //This method is called by class MinFrame when a button in teh GUI is pressed
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
    
    public void addItemToOrder(int selectionIndex) {
        System.out.println("Index selection left panel: " + selectionIndex); //for test purposes  - remove when not needed

        if (selectionIndex != -1){ // if something is selected in the left menu list
            switch (currentLeftMenu) { //This might need to change depending on architecture
                case Cake:
                    currentOrder.addProduct(cakes[selectionIndex]);
                    break;
                case PerUnitItem:
                    currentOrder.addProduct(perUnitItems[selectionIndex]);
                    break;
            }
            nbrOfOrders++; //for test purposes - need to be removed or changed when model for handling orders is implemented            
            
            setCurrentOrderRightPanel();            
        }

    }

    public void viewSelectedOrder(int selectionIndex){
        System.out.println("Index selection left panel: " + selectionIndex); //for test purposes  - remove when not needed

        if ((selectionIndex != -1) && currentLeftMenu==ButtonType.OrderHistory){
            costCurrentOrder = 100; //for test purposes - replace with calculation of cost when how orders are handled is implemented in model
            view.populateRightPanel(order1Simulation); //update left panel with order details - this takes a shortcut in updating the entire information in the panel not just adds to the end
            view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        }
    }


    public void setToCakeMenu() {
        currentLeftMenu = ButtonType.Cake;
        String[] cakeMenuString = new String[cakes.length];
        
        for (int i = 0; i < cakes.length; i++) {
            cakeMenuString[i] = cakes[i].toString();    
        }
        view.populateLeftPanel(cakeMenuString);
        System.out.println(Arrays.toString(currentOrderArray));
        
        setCurrentOrderRightPanel();

        view.enableAllButtons();
        view.disableCakeMenuButton();
        view.disableViewSelectedOrderButton();
    }


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

    private void setCurrentOrderRightPanel () {
        String[] orderPurchasesStrings = new String[currentOrder.getPurchases().length];
        for (int i = 0; i < currentOrder.getPurchases().length; i++) {
            orderPurchasesStrings[i] = currentOrder.getPurchases()[i].toString();
        }
        view.populateRightPanel(orderPurchasesStrings); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(currentOrder.getTotalPrice())); //set the text to show cost of current order
    }

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


    public void addNewCake() {
        newCakeType = new CustomCakeFrame(this);
        //For grade VG: Add more code to save the new cake type and update menu,
        view.enableAllButtons();
    }

    public void placeOrder() {
        Order[] newPreviousOrders = new Order[previousOrders.length + 1];
        for (int i = 0; i < previousOrders.length; i++) {
            newPreviousOrders[i] = previousOrders[i];
        } 
        newPreviousOrders[previousOrders.length] = currentOrder;
        previousOrders = newPreviousOrders;
        currentOrder = new Order();
        view.clearRightPanel(); //Removes information from right panel in GUI
        view.setTextCostLabelRightPanel("TOTAL COST: 0");
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }


}
