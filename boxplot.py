import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Integer_SmallArray_Times.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Integer_SmallArray_Times.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Integer_SmallArray_Times.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Integer_SmallArray_Times.csv", header=None).T

# Combine into a single DataFrame
bubble_unc_times['Algorithm'] = 'BubbleSortUntilNoChange'
bubble_needed_times['Algorithm'] = 'BubbleSortWhileNeeded'
quick_times['Algorithm'] = 'QuickSortGPT'
selection_times['Algorithm'] = 'SelectionSortGPT'

df = pd.concat([bubble_unc_times, bubble_needed_times, quick_times, selection_times], ignore_index=True)
df = df.melt(id_vars=['Algorithm'], var_name='Iteration', value_name='Time (ns)')

# Plot the boxplots
plt.figure(figsize=(12, 8))
sns.boxplot(data=df, x='Algorithm', y='Time (ns)')
plt.yscale("log")  # Log scale if needed
plt.title("Execution Time of Sorting Algorithms for small arrays")

# Save the plot to a file
plt.savefig("BoxPlot_Integer_Small_Arrays.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Integer_MediumArray_Times.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Integer_MediumArray_Times.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Integer_MediumArray_Times.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Integer_MediumArray_Times.csv", header=None).T

# Combine into a single DataFrame
bubble_unc_times['Algorithm'] = 'BubbleSortUntilNoChange'
bubble_needed_times['Algorithm'] = 'BubbleSortWhileNeeded'
quick_times['Algorithm'] = 'QuickSortGPT'
selection_times['Algorithm'] = 'SelectionSortGPT'

df = pd.concat([bubble_unc_times, bubble_needed_times, quick_times, selection_times], ignore_index=True)
df = df.melt(id_vars=['Algorithm'], var_name='Iteration', value_name='Time (ns)')

# Plot the boxplots
plt.figure(figsize=(12, 8))
sns.boxplot(data=df, x='Algorithm', y='Time (ns)')
plt.yscale("log")  # Log scale if needed
plt.title("Execution Time of Sorting Algorithms for medium arrays")

# Save the plot to a file
plt.savefig("BoxPlot_Integer_Medium_Arrays.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Integer_LargeArray_Times.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Integer_LargeArray_Times.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Integer_LargeArray_Times.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Integer_LargeArray_Times.csv", header=None).T

# Combine into a single DataFrame
bubble_unc_times['Algorithm'] = 'BubbleSortUntilNoChange'
bubble_needed_times['Algorithm'] = 'BubbleSortWhileNeeded'
quick_times['Algorithm'] = 'QuickSortGPT'
selection_times['Algorithm'] = 'SelectionSortGPT'

df = pd.concat([bubble_unc_times, bubble_needed_times, quick_times, selection_times], ignore_index=True)
df = df.melt(id_vars=['Algorithm'], var_name='Iteration', value_name='Time (ns)')

# Plot the boxplots
plt.figure(figsize=(12, 8))
sns.boxplot(data=df, x='Algorithm', y='Time (ns)')
plt.yscale("log")  # Log scale if needed
plt.title("Execution Time of Sorting Algorithms for large arrays")

# Save the plot to a file
plt.savefig("BoxPlot_Integer_Large_Arrays.png", format="png", dpi=300)

plt.show()
