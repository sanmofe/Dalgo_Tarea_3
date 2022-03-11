package PankacesProblem;

import java.util.ArrayList;
import java.util.Stack;

public class PancakeSorting {

	public PancakeSorting()
	{
		
	}
	
	public void printArray(Stack<Integer>A)
	{
		System.out.println(""+A);
	}
	
	public void bringToTop(Stack<Integer>arr)
	{
		int[] enteroPos;
		int variable;
		int contador=0;
		Stack<Integer> arreglo =(Stack<Integer>) arr.clone();
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
		ArrayList<Integer> aux = new ArrayList<>();
		for (int i = A.size()-1; i >= pos-1; i--) {
			aux.add(A.pop());
		}
		for (int i = 0; i < aux.size(); i++) {
			A.push(aux.get(i));
		}
	}
	
	public boolean checkearArreglo(Stack<Integer>A)
	{
		boolean correcto=true;
		String rta = "El arreglo es correcto";
		for (int i = 0; i < A.size()-2; i++) {
				if(A.get(i)<A.get(i+1))
				{
					rta = "El arreglo no es correcto";
					correcto =false;
				}
		}
		System.out.println(rta);
		return correcto;
	}
}
