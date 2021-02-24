package Project1;

import java.io.File;
import java.io.IOException;
import java.util.*;
//--------------------------------------WelcomePage Functions------------------------------------------
public class JavaFileHandlerApplication {
	public void border()
	{
	for(int j=0;j<2;j++) {
		for(int i=0;i<140;i++) {
		System.out.print("*");
		}
		System.out.println();
		}
	}
	
private void space() {
	for(int i=0;i<56;i++) {
	System.out.print(" ");
	}
}
private void WelcomePage() {
	JavaFileHandlerApplication obj=new JavaFileHandlerApplication();
	System.out.println();
	obj.space();
	System.out.print("RS FILEHANDLING APPLICATION");
	obj.space();
	System.out.println();
	System.out.println();
	obj.space();
	System.out.print("       by R RAJASEKAR");
	obj.space();
	System.out.println();
	System.out.println();
}
//------------------------------------------------HomePage Functions------------------------------------------------
private void Order() {
	File file=new File("D://");
	System.out.println("Files in "+file.getAbsolutePath()+" Path is");
	String arr[]=file.list();
	Set<String> treeset=new TreeSet<String>();
	int m=0;
	for(String j:arr)
	{
		m++;
		treeset.add(j);
		System.out.println("    "+m+"."+j);
	}
//	File file=new File("D:\\");
//	String arr[]=file.list();
//	System.out.println();
//	System.out.println("Files in "+file.getAbsolutePath()+" Path is");
//	for(int i=1;i<arr.length;i++)
//	{
//		System.out.println("    "+i+". "+arr[i]);
//	}
}
private void UserInteraction() {
	border();
	System.out.println();
	System.out.println("Please select which kind of file operation you want to perform");
	System.out.println();
	System.out.println("1.Add File");
	System.out.println("2.Delete File");
	System.out.println("3.Search File");
	System.out.println("4.Navigate to Main");
	System.out.println();
	Scanner scan=new Scanner(System.in);
	JavaFileHandlerApplication obj=new JavaFileHandlerApplication();
	int input=scan.nextInt();
	switch(input) {
	case 1:{
		try {
			obj.AddFile();
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	case 2:{
		try {
			obj.DeleteFile();
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	case 3:{
		try {
			obj.SearchFile();
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	case 4:{
		try {
			obj.NavigateFile();
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}
//------------------------------------------------Menu for input Selection----------------------------------------------
public void MenuPage() {
	try{
	System.out.println();
	System.out.println("Welcome to the RS FileHandling application");
	System.out.println();
	System.out.println("Please select operations which you want");
	System.out.println("	1.Listout the Files name in Asc order");
	System.out.println("	2.User Interaction Operations");
	System.out.println("	3.Close the Application");
	System.out.println("Note : Give your input as integer(Numers) corresponding to the option listed.");
	JavaFileHandlerApplication obj=new JavaFileHandlerApplication();
	Scanner scan=new Scanner(System.in);
	int option=scan.nextInt();
	switch(option) {
	case 1:{
		//listing function
		obj.Order();
		obj.MenuPage();
		break;
	}
	case 2:{
		//Add,Delete,Search,Navigate
		obj.UserInteraction();
		break;
	}
	case 3:{
		//exit
		Runtime.getRuntime().exit(0); // or System.exit(0);
		break;
	}
	}
		}
	catch(Exception e)
	{
		System.out.println("Exception catched in Menu page:"+e);
	}
}
//-----------------------------User Interaction Functions(Add,delete,search,navigate file)----------
public void AddFile() throws IOException {
	System.out.println("Please enter Filename with format(e.g:.txt,.doc)");
	System.out.println("Note: Enter 'e' to exit and 'c' for continue(give after enter the filename)");
	Scanner scan=new Scanner(System.in);
	String filename=scan.nextLine();
	if(filename.equals("e")||filename.equals("c")||filename.equals(""))
	{
		System.out.println("Please enter valid Filename");
		System.out.println();
		AddFile();
	}
	else {
		File file=new File("D:\\"+filename);
		if(file.exists())
		{
			System.out.println("File Already Exist!");
			System.out.println();
			char input=scan.next().charAt(0);
			if(input=='e') {
				UserInteraction();
			}
			else if(input=='c') {
				AddFile();
			}
			else {
				System.out.println("invalid input!");
				MenuPage();
			}
		}else {
			file.createNewFile();
			System.out.println("File Created Successfully!");
			System.out.println();
			char input=scan.next().charAt(0);
			if(input=='e') {
				UserInteraction();
			}
			else if(input=='c'){
				AddFile();
			}
			else {
				System.out.println("invalid input!");
				MenuPage();
			}
		}	
	}
	
	
	

}
public void DeleteFile() {
	System.out.println("Please enter Filename with format(e.g:.txt,.doc)");
	System.out.println("Note: Enter 'e' to exit and 'c' for continue(give after enter the filename)");
	System.out.println("Please enter file name");
	Scanner scan=new Scanner(System.in);
	String filename=scan.nextLine();
	if(filename.equals("e")||filename.equals("c")||filename.equals(""))
	{
		System.out.println("Please enter valid filename");
		System.out.println();
		DeleteFile();
	}
	else {
	File file=new File("D:\\"+filename);
	File path=new File("D:\\");
	String filecheck=file.getName();
	String arr[]=path.list();
	int count=0;
	for(int i=1;i<arr.length;i++)
	{
		if(arr[i].equals(filecheck))
		{
			file.delete();
			System.out.println("File Deleted successfully");
			count=1;
			System.out.println();
			char input=scan.next().charAt(0);
			if(input=='e') {
				UserInteraction();
			}
			else if(input=='c'){
				DeleteFile();
			}
			else {
				System.out.println("invalid input!");
				MenuPage();
			}
		}else {
			continue;
		}
	}
	if(count==0) {
		System.out.println("File not found!(Note:Case sensitive)");
		System.out.println();
		char input=scan.next().charAt(0);
		if(input=='e') {
			UserInteraction();
		}
		else if(input=='c'){
			DeleteFile();
		}
		else {
			System.out.println("invalid input!");
			MenuPage();
		}
	}
}
}
public void NavigateFile() {
	JavaFileHandlerApplication obj=new JavaFileHandlerApplication();
	obj.MenuPage();
}
public void SearchFile() {
	Scanner scan=new Scanner(System.in);
	System.out.println("Please enter File name you want to search");
	String input=scan.nextLine();
	File file=new File("D:\\"+input);
	if(file.exists())
	{
		System.out.println("File Founded!");
		System.out.println();
		char check=scan.next().charAt(0);
		if(check=='e') {
			UserInteraction();
		}
		else if(check=='c'){
			SearchFile();
		}
		else {
			System.out.println("invalid input!");
			MenuPage();
		}
	}
	else
	{
		System.out.println("File Not Found!");
		System.out.println();
		char check=scan.next().charAt(0);
		if(check=='e') {
			UserInteraction();
		}
		else if(check=='c'){
			SearchFile();
		}
		else {
			System.out.println("invalid input!");
			MenuPage();
		}
	}
}
//-----------------------------------------------------------------------------------------------
public static void main(String[] args) 
{
	try{
	JavaFileHandlerApplication obj=new JavaFileHandlerApplication();
	obj.border();
	obj.WelcomePage();
	obj.border();
	
Scanner scan=new Scanner(System.in);
System.out.print("Enter 's' to Start the application");
char start=scan.next().charAt(0);
if(start=='s')
{
	obj.MenuPage();
}
else 
{
	System.out.print("invalid input");
	obj.MenuPage();
}
	}
	catch(Exception e)
	{
		System.out.println("Exception in Main:"+e);
	}
}
}