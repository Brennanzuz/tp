package seedu.duke.medicine;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * @author tanyizhe
 *     This class manages Medicines that will be prescribed to patients.
 */
public class MedicineManager {
    private static Dictionary<String, ArrayList<Medicine>> medicationDict = new Hashtable<>();
    private static Dictionary<String, String> medicineDosages = new Hashtable<>();
    private final Medicine PARACETAMOL = new Medicine("Paracetamol", "1 or 2 pills up to 3 times a day");
    private final Medicine LOZENGE = new Medicine("Lozenges","When you feel pain from sore throat");
    private final Medicine ROBITUSSIN = new Medicine("Robitussin", "20ml every 12 hours");
    private final Medicine IBUPROFEN = new Medicine("Ibuprofen",  "1 or 2 pills every 4 to 6 hours");
    private final Medicine ASPIRIN = new Medicine("Aspirin", "1 or 2 pills every 4 to 6 hours");
    public MedicineManager() {
        initialiseMedications();
        initialiseMedicineDosages();
    }

    /**
     * This Method initialises the dictionary of Illnesses and Medications. The keys are the names of illnesses
     * and the values are an ArrayList of medications.
     */
    private void initialiseMedications () {
        ArrayList<Medicine> covidMedications = Stream.of(PARACETAMOL, LOZENGE, ROBITUSSIN)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Medicine> commonColdMedications = Stream.of(IBUPROFEN, ASPIRIN, ROBITUSSIN)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Medicine> migraineMedications = Stream.of(IBUPROFEN, ASPIRIN)
                .collect(Collectors.toCollection(ArrayList::new));
        medicationDict.put("Covid-19", covidMedications);
        medicationDict.put("Common Cold", commonColdMedications);
        medicationDict.put("Migraine", migraineMedications);
    }
    /**
     * This Method initialises the dictionary of Medications and their dosages.
     * The keys are the names of Medications and the values is a string that describes dosage.
     */
    public void initialiseMedicineDosages() {
        medicineDosages.put(PARACETAMOL.toString(), PARACETAMOL.getDosage());
        medicineDosages.put(ROBITUSSIN.toString(), ROBITUSSIN.getDosage());
        medicineDosages.put(LOZENGE.toString(), LOZENGE.getDosage());
        medicineDosages.put(ASPIRIN.toString(), ASPIRIN.getDosage());
        medicineDosages.put(IBUPROFEN.toString(), IBUPROFEN.getDosage());
        System.out.println(medicineDosages.get("Aspirin"));
    }
    /**
     * Prescribes appropriate medications to patients.
     * @param illness Name of illness diagnosed by Dr. Duke.
     * @return an ArrayList of prescribed medications.
     */
    public ArrayList<Medicine> getPrescribedMedication (String illness) {
        return medicationDict.get(illness);
    }
    /**
     * Gets dosage for medicine.
     * @param name name of medication
     * @return dosage of specified medication
     */
    public String getMedicineDosages (String name) {
        return medicineDosages.get(name);
    }
}