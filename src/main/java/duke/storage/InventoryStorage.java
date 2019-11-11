package duke.storage;

import duke.model.list.inventorylist.InventoryList;
import duke.model.task.ingredienttasks.Ingredient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import static duke.common.Messages.filePathInventoryTest;

/**
 * Handles the ability to read and write to the inventory storage location.
 */
public class InventoryStorage {

    private static final HashMap<String, Ingredient> inventoryListHM = new HashMap<>();
    private final String filePathInventory;

    /**
     * Constructor for the class InventoryStorage.
     *
     * @param filePathInventory the directory in which the inventory are to be stored
     */
    public InventoryStorage(String filePathInventory) {
        this.filePathInventory = filePathInventory;
    }

    /**
     * Writes to file to save the inventory to file.
     *
     * @param inventoryList the list containing inventory
     */
    public void saveFile(InventoryList inventoryList) {
        try {
            FileWriter fileWriter = new FileWriter(filePathInventory);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            inventoryList.getInventoryList().forEach((String, Ingredient) ->
            {
                try {
                    bufferedWriter.write(Ingredient.toSaveString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bufferedWriter.close();
        } catch (Exception exc) {
            exc.printStackTrace(); // If there was an error, print the info.
        }
    }

    /**
     * Loads all the save inventory in the file.
     *
     * @return the list of inventory in inventory list
     */
    public HashMap<String, Ingredient> load() {
        if (Files.notExists(Paths.get(filePathInventory))) {
            try {
                File file = new File(filePathInventory);
                file.getParentFile().mkdir();
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Unknown IO error when creating 'data/' folder.");
            }
        }

        try {
            InputStream inputStream;
            if (filePathInventory.equals(filePathInventoryTest)) {
                inputStream = getClass().getResourceAsStream("/datatest/inventoriesTest.txt");
            } else {
                inputStream = getClass().getResourceAsStream("/data/inventories.txt");
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileReader fileReader = new FileReader(filePathInventory);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader);
            String content = "";
            while ((content = bufferedReader.readLine()) != null || (content = bufferedReader1.readLine()) != null) {
                String ingredientName, quantity, unit, additionalInfo, remaining, remaining2;
                String[] split = content.split(",", 2);
                if (split.length == 2) {
                    ingredientName = split[0].trim();
                    remaining = split[1].trim();
                    String[] split2 = remaining.split(",", 2);
                    if (split2.length == 2) {
                        quantity = split2[0].trim();
                        remaining2 = split2[1].trim();
                        String[] split3 = remaining2.split(",", 2);
                        if (split3.length == 2) {
                            unit = split3[0].trim();
                            additionalInfo = split3[1].trim();
                            Ingredient ingredient = new Ingredient(ingredientName, quantity, unit, additionalInfo);
                            inventoryListHM.put(ingredientName, ingredient);
                        }
                    }
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePathInventory + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + filePathInventory + "'");
        }
        return inventoryListHM;
    }
}
