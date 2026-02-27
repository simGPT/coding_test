import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SelectionSort{
	int size;
	int [] list;
	
	public SelectionSort(int list[]){
		this.list = list;
		size = list.length;
		DoSelectionSort(list); // 미리 생성자에서 함수 호출
	}
	public void DoSelectionSort(int list[]) {
		for(int i=0; i<size-1; i++) {
			int min_index = i;
			
			for(int j = i+1; j<size; j++) {
				if(list[min_index]>list[j]) {
					min_index = j;
				}
			}
			swap(i, min_index, list);
		}
	}
	public void swap(int a, int b, int list[]) {
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
}

public class Main {
	public static void main(String[]args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s);
		int [] list = new int[n];
		for(int i = 0; i<n; i++) {
			s = br.readLine();
			list[i] = Integer.parseInt(s);
		}
		SelectionSort sort = new SelectionSort(list);
		
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
	}
}