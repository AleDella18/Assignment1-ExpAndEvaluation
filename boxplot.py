import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Times.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Times.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Times.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Times.csv", header=None).T

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
plt.title("Execution Time of Sorting Algorithms")
plt.show()
