import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Integer_0.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Integer_0.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Integer_0.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Integer_0.csv", header=None).T

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
plt.title("Integer test / Small size / Already sorted")

# Save the plot to a file
plt.savefig("BoxPlot_Integer_Small_Array_Already_Sorted.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Integer_1.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Integer_1.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Integer_1.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Integer_1.csv", header=None).T

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
plt.title("Integer test / Small size / Reverse sorted")

# Save the plot to a file
plt.savefig("BoxPlot_Integer_Small_Array_Reverse_Sorted.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Integer_2.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Integer_2.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Integer_2.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Integer_2.csv", header=None).T

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
plt.title("Integer test / Small size / Random ordered")

# Save the plot to a file
plt.savefig("BoxPlot_Integer_Small_Array_Random_Ordered.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Integer_3.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Integer_3.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Integer_3.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Integer_3.csv", header=None).T

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
plt.title("Integer test / Medium size / Already sorted")

# Save the plot to a file
plt.savefig("BoxPlot_Integer_Medium_Array_Already_Sorted.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Integer_4.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Integer_4.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Integer_4.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Integer_4.csv", header=None).T

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
plt.title("Integer test / Medium size / Reverse sorted")

# Save the plot to a file
plt.savefig("BoxPlot_Integer_Medium_Array_Reverse_Sorted.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Integer_5.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Integer_5.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Integer_5.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Integer_5.csv", header=None).T

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
plt.title("Integer test / Medium size / Random ordered")

# Save the plot to a file
plt.savefig("BoxPlot_Integer_Medium_Array_Random_Ordered.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Integer_6.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Integer_6.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Integer_6.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Integer_6.csv", header=None).T

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
plt.title("Integer test / Large size / Already sorted")

# Save the plot to a file
plt.savefig("BoxPlot_Integer_Large_Array_Already_Sorted.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Integer_7.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Integer_7.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Integer_7.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Integer_7.csv", header=None).T

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
plt.title("Integer test / Large size / Reverse sorted")

# Save the plot to a file
plt.savefig("BoxPlot_Integer_Large_Array_Reverse_Sorted.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_Integer_8.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_Integer_8.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_Integer_8.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_Integer_8.csv", header=None).T

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
plt.title("Integer test / Large size / Random ordered")

# Save the plot to a file
plt.savefig("BoxPlot_Integer_Large_Array_Random_Ordered.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_String_0.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_String_0.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_String_0.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_String_0.csv", header=None).T

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
plt.title("String test / Small size / Already sorted")

# Save the plot to a file
plt.savefig("BoxPlot_String_Small_Array_Already_Sorted.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_String_1.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_String_1.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_String_1.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_String_1.csv", header=None).T

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
plt.title("String test / Small size / Reverse sorted")

# Save the plot to a file
plt.savefig("BoxPlot_String_Small_Array_Reverse_Sorted.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_String_2.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_String_2.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_String_2.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_String_2.csv", header=None).T

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
plt.title("String test / Small size / Random ordered")

# Save the plot to a file
plt.savefig("BoxPlot_String_Small_Array_Random_Ordered.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_String_3.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_String_3.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_String_3.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_String_3.csv", header=None).T

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
plt.title("String test / Medium size / Already sorted")

# Save the plot to a file
plt.savefig("BoxPlot_String_Medium_Array_Already_Sorted.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_String_4.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_String_4.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_String_4.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_String_4.csv", header=None).T

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
plt.title("String test / Medium size / Reverse sorted")

# Save the plot to a file
plt.savefig("BoxPlot_String_Medium_Array_Reverse_Sorted.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_String_5.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_String_5.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_String_5.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_String_5.csv", header=None).T

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
plt.title("String test / Medium size / Random ordered")

# Save the plot to a file
plt.savefig("BoxPlot_String_Medium_Array_Random_Ordered.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_String_6.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_String_6.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_String_6.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_String_6.csv", header=None).T

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
plt.title("String test / Large size / Already sorted")

# Save the plot to a file
plt.savefig("BoxPlot_String_Large_Array_Already_Sorted.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_String_7.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_String_7.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_String_7.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_String_7.csv", header=None).T

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
plt.title("String test / Large size / Reverse sorted")

# Save the plot to a file
plt.savefig("BoxPlot_String_Large_Array_Reverse_Sorted.png", format="png", dpi=300)

plt.show()

# Load the CSV files
bubble_unc_times = pd.read_csv("BubbleSortUntilNoChange_String_8.csv", header=None).T
bubble_needed_times = pd.read_csv("BubbleSortWhileNeeded_String_8.csv", header=None).T
quick_times = pd.read_csv("QuickSortGPT_String_8.csv", header=None).T
selection_times = pd.read_csv("SelectionSortGPT_String_8.csv", header=None).T

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
plt.title("String test / Large size / Random ordered")

# Save the plot to a file
plt.savefig("BoxPlot_String_Large_Array_Random_Ordered.png", format="png", dpi=300)

plt.show()