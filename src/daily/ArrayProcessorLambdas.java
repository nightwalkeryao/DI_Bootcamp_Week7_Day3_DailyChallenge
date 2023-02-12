package daily;

public class ArrayProcessorLambdas {
		public static final ArrayProcessor max = (double[] array) -> {
			double maxValue = Double.NEGATIVE_INFINITY;
			for (double value : array) {
				maxValue = Math.max(maxValue, value);
			}
			return maxValue;
		};

		public static final ArrayProcessor min = (double[] array) -> {
			double minValue = Double.POSITIVE_INFINITY;
			for (double value : array) {
				minValue = Math.min(minValue, value);
			}
			return minValue;
		};

		public static final ArrayProcessor sum = (double[] array) -> {
			double total = 0;
			for (double value : array) {
				total += value;
			}
			return total;
		};

		public static final ArrayProcessor average = (double[] array) -> {
			return sum.apply(array) / array.length;
		};

		public static ArrayProcessor counter(double value) {
			return (double[] array) -> {
				int count = 0;
				for (double val : array) {
					if (val == value) {
						count++;
					}
				}
				return count;
			};
		}
		
		
		public static void main(String[] args) {
		    double[] array = {14, 15, 43, 7, 25, 66, 22, 78, 5., 55,95};
		    
		    System.out.println("The max value is : " + max.apply(array));
		    System.out.println("The min value is : " + min.apply(array));
		    System.out.println("The sum of values in table is : " + sum.apply(array));
		    System.out.println("The average of values in table is : " + average.apply(array));
		    
		    ArrayProcessor countFive = counter(5);
		    System.out.println("The number of apparition of 5 is : " + countFive.apply(array));
		  }
}
