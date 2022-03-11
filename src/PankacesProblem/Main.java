

package PankacesProblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Programa que resuelve el problema de los panqueques
 * @author David Cruz
 * @author Santiago Mora
 * @author Serguio Guillen
 * @author Juan Castaño
 * Editado por Nelson Sanchez
 */
public class Main 
{
	
	
	
	public static void main(String[] args)
	{
		PancakeSorting sorter = new PancakeSorting();
		
		try 
		{
			InputStreamReader in = new InputStreamReader(System.in);
			//FileReader read = new FileReader("./data/prueba");
			BufferedReader br = new BufferedReader(in);
			int pos=2;
			
			String line = br.readLine();
			
			while(line!=null)
			{
				String [] dataStr = line.split(" ");
				Stack<Integer> numeros= new Stack<>();
				for(int i =0;i<dataStr.length;i++)
				{
					Integer value = Integer.parseInt(dataStr[i]);
					numeros.push(value);
				}
				if(pos < numeros.size()&& pos>0)
				{
					sorter.bringToTop(numeros);
					sorter.printArray(numeros);
					sorter.checkearArreglo(numeros);
				}
				line = br.readLine();
			}
			br.close();
			//read.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static class PancakeSorting {

		public PancakeSorting()
		{

		}

		public void printArray(Stack<Integer>A)
		{
			System.out.println(""+A);
		}

		public void bringToTop(Stack<Integer>arr)
		{
			if (checkearArreglo(arr)){
				System.out.println("ORDENADO");
				return;
			}

			int[] enteroPos;
			int variable;
			int contador=0;
			Stack<Integer> arreglo = (Stack<Integer>) arr.clone();
			Stack<Integer> aux = arreglo;
			for (int i = 0; !aux.isEmpty(); i++)
			{
				enteroPos= buscarMayor(aux);
				if(enteroPos[1]==0)
				{
					aux.remove(0);
					contador++;
				}
				else if(enteroPos[1]!=aux.size()-1)
				{
					variable = buscarPos(enteroPos[0], arr);
					flip(arr,variable+1);
					variable = buscarPos(enteroPos[0], aux);
					flip(aux,variable+1);
				}
				else if(enteroPos[1]==aux.size()-1)
				{
					variable = buscarPos(enteroPos[0], arr);
					flip(arr, contador+1);
					variable = buscarPos(enteroPos[0], aux);
					flip(aux,1);
				}
			}
		}

		public int buscarPos(int a, Stack<Integer> array)
		{
			int posbuscada =0;
			for (int i = 0; i < array.size(); i++)
			{
				if(a==array.get(i))
				{
					posbuscada=i;
				}
			}
			return posbuscada;
		}

		public int[] buscarMayor(Stack<Integer>array)
		{
			int posMayor=0;
			int mayor=0;
			int[] respuesta = new int[2];
			for (int i = 0; i < array.size(); i++)
			{
				if(array.get(i)>mayor)
				{
					mayor= array.get(i);
					posMayor=i;
				}
			}
			respuesta[0]= mayor;
			respuesta[1]= posMayor;
			return respuesta;
		}

		public void flip(Stack<Integer>A, int pos)
		{
//			System.out.println(pos);
//			ArrayList<Integer> aux = new ArrayList<>();
//			for (int i = A.size()-1; i >= pos-1; i--) {
//				aux.add(A.pop());
//			}
//			for (int i = 0; i < aux.size(); i++) {
//				A.push(aux.get(i));
//			}
			pos = pos -1;
			System.out.print(pos + " ");
			List<Integer> aux = A.subList(pos, A.size());
			Collections.reverse(aux);
		}

		public boolean checkearArreglo(Stack<Integer>A)
		{
			boolean correcto=true;
			for (int i = 0; i < A.size()-2; i++) {
				if(A.get(i)<A.get(i+1))
				{
					correcto =false;
				}
			}
			return correcto;
		}
	}

}
