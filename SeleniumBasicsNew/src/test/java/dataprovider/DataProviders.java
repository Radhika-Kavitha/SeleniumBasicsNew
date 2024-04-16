package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="InvalidUserCredentials")
	public Object userCredentialsData()
	{
		Object data[][]	= new String [3][2];
		
		data[0][0]="shandgeotom786@gmail.com";
		data[0][1]="EASTdER%egg4";
		
		data[1][0]="shangeeotom786@gmail.com";
		data[1][1]="EASTER%egg4";
		
		data[2][0]="shangeotom786@gmail.com";
		data[2][1]="EASTERe%egg4";
		
		return data;
	}
}
