    /* This class is peforms different functionalies related to a departmental store like
     1. Dispaly all items details
     2. purchase an item
     3. search for a specific item
     4. display all low stock item details
    */
    
    import java.util.Scanner;
    public class Bob
    {
     public static void main(String[] args)
     {
      //Scanner in = new Scanner(System.in);
     
      // Declare and initialize arrays with the details of 5 items
      String itemcode[] = {"1","2","3","4","5"};
      String itemDescription[] ={"Cheese","Oreo","Chicken","Toblerone","Milk"};
      int quantityAvailable[] = {9,58,8,209,77};
      double unitPrices[] = {14.99, 6.50, 25.75, 8.50, 11.00 };
      int reorderLevels[] = {10,20,4,60,50};
     
      // Accept user credentials and validate those
      validateUser();
    
      int choice;
      do{
        choice = displayChoice();
     
        switch(choice)
        {
         case 1:
         displayItemDetails(itemcode,itemDescription,quantityAvailable,unitPrices,reorderLevels);
         break;
       
         case 2:
         purchaseItem(itemcode,itemDescription,quantityAvailable,unitPrices,reorderLevels);
         break;
       
         case 3:
         searchItem(itemcode,itemDescription,quantityAvailable,unitPrices,reorderLevels);
         break;
       
         case 4:
         lowStockItems(itemcode,itemDescription,quantityAvailable,unitPrices,reorderLevels);
         break;
       
         case 5:
         System.out.println("Exitting the program.");
         break;
       
         default:
         System.out.println("Please enter a valid choice");
         break;
        }
       }while (choice != 5);
      }
     
      public static void validateUser()
      {
          Scanner in = new Scanner(System.in);
       // Store usernames and passwords in two arrays
       String[] users = { "Teacher", "Parents", "Invigilator" };
       String[] passwords = { "School", "Home", "Exam" };
       boolean chk;
       do{
         System.out.println("Enter Username:");
         String username = in.nextLine();
         System.out.println("\n");
         System.out.println("Enter Password:");
         String password = in.nextLine();
         System.out.println("\n");
     
         chk = false;
     
         for(int i = 0;i < users.length;i++)
         {
           if(users[i].equals(username) && passwords[i].equals(password))
           {
             chk = true;
           }
         }
     
         if(chk == false)
         {
           System.out.println("Invalid username or Password");
         }
       }while (chk == false);
      }
     
     /* Display all menu options and return the selected choice.
       It also validates that entered choice is an integer or not */
    
      public static int displayChoice()
      {
          Scanner in = new Scanner(System.in);
       System.out.println("MAIN MENU \n");
       System.out.println("1. Display all the items in stock");
       System.out.println("2. Purchase an item");
       System.out.println("3. Search an Item by Name");
       System.out.println("4. Display the details of items that have gone below the reorder level");
       System.out.println("5. Exit\n");
     
       //Choice
       System.out.println("Enter your choice as number:");
       int choice = in.nextInt();
       return choice;
      }
     
     // Display all the item details which are below the reorder level
     
      public static void lowStockItems(String itemcode[],String itemDescription[],int quantityAvailable[],double unitPrices[],
      int reorderLevels[])
      {
       System.out.println("\nLow Stock Items:");
       String headers[] = {"Itemcode", "Item description", "Quantity available", "Reorder level","Unit Price"};
       for(int i =0; i<headers.length; i++)
       {
         for(int j=headers[i].length(); j<=20; j++)
          headers[i] += " ";
         System.out.print(headers[i]);
       }
       System.out.println();
         
       for (int i = 0; i < itemcode.length; i++) {
         if (quantityAvailable[i] < reorderLevels[i]) {
          String quantity = String.valueOf(quantityAvailable[i]);
           String reorder = String.valueOf(reorderLevels[i]);
           String price = String.valueOf(unitPrices[i]);
           for(int j =itemcode[i].length(); j<=20; j++)
           {
             itemcode[i] += " ";
           }
           for(int j=itemDescription[i].length(); j<=20; j++)
           {
             itemDescription[i] += " ";
           }
           for(int j=quantity.length(); j<=20; j++)
           {
             quantity += " ";
           }
           for(int j=reorder.length(); j<=20; j++)
           {
             reorder += " ";
           }
           for(int j=price.length(); j<=20; j++)
           {
             price += " ";
           }
     
           System.out.println(itemcode[i]+itemDescription[i]+quantity+reorder+price);
         }
       }
      }
     
     /* Search for an item based on the item description.
       If it doesnt matches matches display the message accordingly */
     
      public static void searchItem(String itemcode[],String itemDescription[],int quantityAvailable[],double unitPrices[],
      int reorderLevels[])
      {
        Scanner scanner = new Scanner(System.in);
          System.out.print("Enter the item name to search: ");
          String itemName = scanner.nextLine().toLowerCase();
    
          boolean itemFound = false;
    
          for (int i = 0; i < itemDescription.length; i++)
          {
            if (itemDescription[i].toLowerCase().equals(itemName.toLowerCase()))
            {
              System.out.println("\nSearch Results:");
              String headers[] = {"Itemcode", "Item description", "Quantity available", "Reorder level","Unit Price"};
             
              for(int k =0; k<headers.length; k++)
              {
                  for(int j=headers[k].length(); j<=20; j++)
                      headers[k] += " ";
                  System.out.print(headers[k]);
              }
              System.out.println();
              String quantity = String.valueOf(quantityAvailable[i]);
              String reorder = String.valueOf(reorderLevels[i]);
              String price = String.valueOf(unitPrices[i]);
              for(int j =itemcode[i].length(); j<=20; j++)
              {
                itemcode[i] += " ";
              }
              for(int j=itemDescription[i].length(); j<=20; j++)
              {
                itemDescription[i] += " ";
              }
              for(int j=quantity.length(); j<=20; j++)
              {
                quantity += " ";
              }
              for(int j=reorder.length(); j<=20; j++)
              {
                reorder += " ";
              }
              for(int j=price.length(); j<=20; j++)
              {
                price += " ";
              }
       
              System.out.println(itemcode[i]+itemDescription[i]+quantity+reorder+price);
              itemFound = true;
            }
          }    
    
          if (itemFound == false)
          {
            System.out.println("Item not found.");
          }
      }
     
     // purchase and item and update the inventory accordingly
     
      public static void purchaseItem(String itemcode[],String itemDescription[],int quantityAvailable[],double unitPrices[],
      int reorderLevels[])
      {
          Scanner in = new Scanner(System.in);
       System.out.print("Enter the item code to purchase: ");
       String input_itemCode = in.next();
       boolean itemFound = false;
    
       for (int i = 0; i < itemcode.length; i++)
       {
           //System.out.println(input_itemCode);
           //System.out.println(itemcode[i]);
        if (itemcode[i].equals(input_itemCode))
        {
          // quantity will be asked to user if itemcode is present in system
          System.out.println("Enter the quantity to be purchased: ");
          int quantityPurchased = in.nextInt();
          if(quantityPurchased > quantityAvailable[i])
          {
            System.out.println("Purchase unsuccessfull,because quantity to be purchased more than quantity available.");
            break;
          }
          itemFound = true;
          quantityAvailable[i] -= quantityPurchased;
          System.out.println(quantityPurchased + " units of " + itemDescription[i] + " purchased successfully!");
          System.out.println("Now total available units are: " + quantityAvailable[i]);
          System.out.println("\n");
          break;
        }
       }
     
       if(!itemFound)
       {
        System.out.println("Item not found. Please enter a valid item code.");
       }
      }
     
     
     // Display all item details
     
      public static void displayItemDetails(String itemcode[],String itemDescription[],int quantityAvailable[],double unitPrices[],
      int reorderLevels[])
      {
          Scanner in = new Scanner(System.in);
         System.out.println();
         System.out.println("Item details:\n");
         String headers[] = {"Itemcode", "Item description", "Quantity available", "Reorder level","Unit Price"};
         for(int i =0; i<headers.length; i++)
         {
           for(int j=headers[i].length(); j<=20; j++)
            headers[i] += " ";
           System.out.print(headers[i]);
         }
         System.out.println();
         
         for(int i=0; i<itemcode.length; i++)
         {
           String quantity = String.valueOf(quantityAvailable[i]);
           String reorder = String.valueOf(reorderLevels[i]);
           String price = String.valueOf(unitPrices[i]);
           String code = itemcode[i];
           String description = itemDescription[i];
           for(int j =code.length(); j<=20; j++)
           {
             code += " ";
           }
           for(int j=description.length(); j<=20; j++)
           {
             description += " ";
           }
           for(int j=quantity.length(); j<=20; j++)
           {
             quantity += " ";
           }
           for(int j=reorder.length(); j<=20; j++)
           {
             reorder += " ";
           }
           for(int j=price.length(); j<=20; j++)
           {
             price += " ";
           }
     
           System.out.println(code+description+quantity+reorder+price);
         }
      }
    }
    /*
   ------------------------------------------------------------------------------------------------
   |   Name of the variable   |    Data type      |      Description                              |
   ------------------------------------------------------------------------------------------------
   |     itemcode             |   String[]        |  Stores all alphanumeric the item codes.      |
   |     itemDescription      |   String[]        |  Stores all items description.                | 
   |     quantityAvailable    |   int[]           |  Stores available quantities of the items.    |
   |     unitPrice            |   int[]           |  Stores the price of an item.                 |
   |     reorderLevels        |   int[]           |  Stores the values below which if avaiable    |
   |                          |                   |  quantity of an item goes then we should      |
   |                          |                   |  reorder that.                                |
   |    itemFound             |   boolean         |  Checks if entered item found or not.         |
   |    quantityPurchased     |   int             |  quantity entered by user to purchase an item |
   |    itemName              |   String          |  user input to search for an item.            |
   |    in                    |   Scanner         |  to accept user input from command line.      |
   -------------------------------------------------------------------------------------------------
*/