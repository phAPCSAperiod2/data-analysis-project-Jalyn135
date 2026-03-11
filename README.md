[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22617125)
# AP CSA Mini‑Project: Data Analysis with Arrays & File Input
### Using CSV Files • Arrays of Objects • Algorithms • Data Ethics & Quality

---

## 📌 Project Overview
In this mini‑project, you will choose a dataset (CSV file), design a **custom class** to represent each row, read the dataset using the **Scanner** class, store all data as **objects** in an ArrayList or array, and answer a **guiding question** by analyzing the data.

This project reinforces:

- Arrays & ArrayLists  
- File input with `Scanner`  
- Class design (attributes, constructors, methods)  
- Algorithms (min, max, average, filtering)  
- Data quality & ethics  
- Documentation using **Javadoc**  
- Creating a **UML class diagram**  

By the end, you will produce insights and answer your original question using your program.

---

## 🎯 Your Task
You will:

1. **Choose a dataset** (teacher provided or public).  
2. **Write a guiding question** for your dataset.  
3. **Design a Java class** with ≥ 3 attributes.  
4. **Use `Scanner` to read a CSV file**, parse rows, and construct objects.  
5. **Store all objects** in an array or ArrayList.  
6. **Analyze the dataset** using algorithms you create.  
7. **Print insights** and answer your guiding question.  
8. **Document your code** with Javadoc.  
9. **Create a UML class diagram** representing your custom class.  

Optional stretch challenges are included at the bottom!

---

## 🧪 Example Questions You Might Ask
Your dataset might allow you to answer things like:

- *"Which Pokémon type has the highest average Attack?"*  
- *"Which U.S. state had the lowest obesity rate in 2020?"*  
- *"What country had the highest CO₂ emissions in 2000?"*  
- *"What is the average HP for Fire-type Pokémon?"*  

Think simple, clear, and answerable.

---

## 📁 Project Structure
Your repository should follow this structure:
```
/src
    Main.java
    YourClass.java
/data
    your_dataset.csv
README.md   ← this file
UML_Diagram.png (or UML_Diagram.pdf)
```

---

## 🧩 Step 1 — Choose Your Dataset

**Dataset Name: World Indicators 2000**  
**Source / Link: https://runestone.academy/ns/books/published/csawesome2/external/_static/datasets/WorldIndicators2000.csv.**  

**What this dataset contains (2–3 sentences): This dataset contains world development indicators for multiple countries across multiple years. It includes the country name, date, and CO₂ emissions data. The program focuses specifically on carbon dioxide emissions and analyzes which country has the highest emissions in the dataset.**  
  

---

## ❓ Step 2 — Write Your Guiding Question

Your guiding question should be something you can answer using your dataset.

**My guiding question: Which country has the highest carbon emissions in this dataset?**  


---

## 🧱 Step 3 — Design Your Class

You must create a class that represents **one row** of your dataset.

### ✔ Your class must include: At least 3 private attributes
private String country;
private double emissions;
private int year;
✅ Constructor that takes all attributes as parameters
public Data(String country, double emissions, int year) {
    this.country = country;
    this.emissions = emissions;
    this.year = year;
}
✅ Getter methods for attributes used in analysis
public String getCountry() {
    return country;
}

public double getEmissions() {
    return emissions;
}

public int getYear() {
    return year;
}

You use:

getEmissions() in your max and average algorithms

getCountry() when printing the country with highest emissions

getYear() when printing the year of the highest emissions

✅ toString() method for easy printing
@Override
public String toString() {
    return country + " | Emissions: " + emissions + " | Year: " + year;
}

This is used when printing:

Highest emissions: China | Emissions: 8286892.0 | Year: 2010

^^^^
- **At least 3 private attributes**  
- **A constructor** that takes all attributes as parameters  
- **Getter methods** for attributes you plan to analyze  
- **`toString()`** for easy printing  
- Any additional analysis/helper methods as needed  

### ✏ Include your class diagram
+--------------------------------+
|             Data               |
+--------------------------------+
| - country : String             |
| - emissions : double           |
| - year : int                   |
+--------------------------------+
| + Data(country:String,         |
|        emissions:double,       |
|        year:int)               |
| + getCountry() : String        |
| + getEmissions() : double      |
| + getYear() : int              |
| + toString() : String          |
+--------------------------------+

---

## 📥 Step 4 — Read Your CSV File Using Scanner

In `Main.java`, you must:

- Create a `File` object  
- Use `Scanner` to read the file  
- Skip the header row (if needed)  
- Read each line  
- Split by commas using `.split(",")`  
- Trim whitespace  
- Parse numbers using `Integer.parseInt()` or `Double.parseDouble()`  
- Construct objects  
- Add them to an ArrayList or array  

### Column → Attribute Map

| Attribute Name | CSV Column Name | Column Index # | Notes |
|----------------|-----------------|----------------|-------|
|   country          |      Country        |  0     |   Stored as a String    |
|   year             |       Date          |  1     |   The dataset stores dates like 12/1/2000. year is taken from the third part  |
|   emissions        |       CO2 Emissions |  4     |   Parsed as a double    |

---

## 📊 Step 5 — Analyze Your Data

You must write **at least two algorithms** to analyze your dataset.

### Required: Choose 2 or more algorithms
- [ ] Minimum value of attribute  
- [ ] Maximum value of attribute  
- [ ] Average of attribute  
- [ ] Filter by category  
- [ ] Count items matching a condition  

**Algorithms I will implement:**

1. Maximum emissions algorithm: Loops through all Data objects. Finds the object with the highest emissions value. Returns that Data object  
2. Average emissions algorithm. Sums all emissions values. Divides by the number of rows. Returns the average as a double

Optional extras:  
- Sorting  
- Top/bottom N items  
- Grouping by category  
- Comparison between groups  

---

## 🧠 Step 6 — Insights & Answer to Your Question

After analyzing your objects, print:

- ✔ How many rows were loaded  
- ✔ Your algorithm results  
- ✔ A clear answer to your guiding question  

**My findings:**  
The program successfully loads all valid rows from the dataset.
It calculates the average CO2 emissions across all countries in the file.
It identifies the single country with the highest emissions and prints the full row (country, emissions, year). (CHINA) 

**My answer to the guiding question:**  
The country with the highest carbon emissions in this dataset is the one returned by findMaxEmissions(). Based on the dataset, this is typically China, with emissions over 8 million metric tons in the year 2010 (my program prints the exact value).

---

## 📝 Step 7 — Documentation Requirements

### ✔ Javadoc Comments
You MUST use Javadoc for:

- Every **class**  
- Every **method**  
- Every **parameter**  
- Every **return value**  

Example:
```java
/**
 * Returns the highest HP among all Pokémon.
 * @param list the ArrayList of Pokémon objects
 * @return highest HP value in the dataset
 */
public static int findMaxHP(ArrayList<Pokemon> list) {
    // implementation
}
```

### ✔ UML Class Diagram
Add a UML diagram showing:

- Class name
- Attributes
- Methods
- Visibility (private/public)

Save as `UML_Diagram.png` or `.pdf` in the repo.
Already listed class diagram previously
---

## 🛡 Step 8 — Data Ethics & Quality Reflection
Write a short reflection (3–5 sentences):

- What data-quality issues did you find?
- Could your dataset be biased?
- How might incomplete or inaccurate data affect results?
- How trustworthy are your insights?

**My reflection:**  
The dataset may contain missing or inconsistent values, which can affect the accuracy of the results. Some rows may have empty fields or formatting issues, so my program skips invalid entries to avoid errors. The dataset could also be biased because it only includes certain years and may not represent all countries equally. If the data is incomplete or outdated, the insights might not reflect real-world conditions today. Overall, the results are trustworthy for the dataset provided, but not necessarily for global emissions trends outside this file.

---

## ⭐ Optional Challenges (Not Required but Fun!)

### 🔹 User Input
Allow the user to choose:

- Which attribute to analyze
- Which category to filter
- What statistics they want to calculate

### 🔹 Additional Algorithms

- Sorting objects
- Multiple comparisons
- Generating summaries
- Exporting results to a file

### 🔹 Data Cleaning

- Skip rows with missing values
- Detect invalid entries
- Normalize units

---

## ✅ Submission Checklist

- [ ] Dataset selected
- [ ] Guiding question written
- [ ] Class created with ≥3 attributes
- [ ] File reading implemented
- [ ] ArrayList/array of objects created
- [ ] At least 2 analysis algorithms implemented
- [ ] Findings printed
- [ ] Javadoc comments added
- [ ] UML diagram included
- [ ] Reflection completed
- [ ] Code compiles & runs

---

Good luck, and have fun exploring your dataset! 🚀  
You're now doing real data analysis — just like professional software engineers.
