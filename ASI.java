package common;

import java.beans.PropertyVetoException;
import java.io.IOException;

import misys.api.H15ARR;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;
import com.ibm.as400.access.QSYSObjectPathName;

public class ASI {

	static boolean _rrec=false;
	static boolean _rval=false;
	static String _dsaim="";
	static ProgramParameter[] _plist;
	static AS400 as400=null;
	
	public static void main(String[] args) {

		String system="192.168.10.116";
		String eqUnit="SBK";
		
		String sUser="",sPass="";
		
		System.out.println("\nConnecting to "+system);
		
		int fCount=0;
			
		try {
			
			//******************************************
			//Environment Setup
			//******************************************
			
			as400=new AS400(system,sUser,sPass);

			System.out.print("Setting up equation unit...");
			
			_plist=new ProgramParameter[2];
			
			AS400Text text400=new AS400Text(3);
			_plist[0]=new ProgramParameter(text400.toBytes(eqUnit));
			
			text400=new AS400Text(4);
			_plist[1]=new ProgramParameter(text400.toBytes("    "));
			
			CallPGM(as400, "KAPBASELIB", "KAPUNLIBL", "PGM", _plist);
			

			if (_rrec) {
				System.out.println("Setting up envrionment...");
				
				_plist=new ProgramParameter[1];
				text400=new AS400Text(1);
				_plist[0]=new ProgramParameter(text400.toBytes(" "));
				
				CallPGM(as400, "KAPBASELIB", "UTM83C", "PGM", _plist);
			}
			
			if (_rrec) {
				System.out.println("Setting up Commitment control envrionment...");
				
				_plist=new ProgramParameter[1];
				text400=new AS400Text(10);
				_plist[0]=new ProgramParameter(text400.toBytes("EQCCSTR   "));
				
				CallPGM(as400, "KAPBASELIB", "Q02HSR ", "PGM", _plist);
			}			
			
			if (_rrec) {
				System.out.println("Setting up user boundry");
				
				_plist=new ProgramParameter[1];
				text400=new AS400Text(10);
				_plist[0]=new ProgramParameter(text400.toBytes("USERBNDON "));
				
				CallPGM(as400, "KAPBASELIB", "Q02HSR ", "PGM", _plist);
			}			
			
					
			//System.out.println(_dsaim);

			if (_rrec) {
			
				System.out.println("Posting entry 1");
				
				H15ARR _h15arr1=new H15ARR();
				_h15arr1.set_GZDIM(7);
				_h15arr1.set_GZWSID("ISKZ");
				_h15arr1.set_GZTIM(140000);
				_h15arr1.set_GZAB("0080");
				_h15arr1.set_GZAN("102000");
				_h15arr1.set_GZAS("001");
				_h15arr1.set_GZPBR("@TST");
				_h15arr1.set_GZBRND("KPY");
				_h15arr1.set_GZDRF("CCTEST 001");
				_h15arr1.set_GZBRNM("SHO");
				_h15arr1.set_GZAMA(10000);
				_h15arr1.set_GZTCD("020");
				_h15arr1.set_GZCCY("LKR");
				_h15arr1.set_GZVFR(1180905);
				_h15arr1.set_GZSEQ(1);
				
				PostEntry(sUser, _h15arr1.GetStructure());
				if(_rval==false)
					fCount++;
				
				
				System.out.println("Posting entry 2");
				
				H15ARR _h15arr2=new H15ARR();
				_h15arr2.set_GZDIM(7);
				_h15arr2.set_GZWSID("ISKZ");
				_h15arr2.set_GZTIM(140000);
				_h15arr2.set_GZAB("0080");
				_h15arr2.set_GZAN("102000");
				_h15arr2.set_GZAS("001");
				_h15arr2.set_GZPBR("@TST");
				_h15arr2.set_GZBRND("KPY");
				_h15arr2.set_GZDRF("CCTEST 001");
				_h15arr2.set_GZBRNM("SHO");
				_h15arr2.set_GZAMA(10000);
				_h15arr2.set_GZTCD("520");
				_h15arr2.set_GZCCY("LKR");
				_h15arr2.set_GZVFR(1180905);
				_h15arr2.set_GZSEQ(2);
				
				
				PostEntry(sUser, _h15arr2.GetStructure());
				if(_rval==false)
					fCount++;
				
			}	
			
			if(fCount>0){
				System.out.println("Rollback...");
				
				_plist=new ProgramParameter[1];
				text400=new AS400Text(10);
				_plist[0]=new ProgramParameter(text400.toBytes("ROLLBACK  "));
				
				CallPGM(as400, "KAPBASELIB", "Q02HSR ", "PGM", _plist);				
				
			}
			
			System.out.println("Ending user boundry");
			
			_plist=new ProgramParameter[1];
			text400=new AS400Text(10);
			_plist[0]=new ProgramParameter(text400.toBytes("USERBNDOFF"));
			
			CallPGM(as400, "KAPBASELIB", "Q02HSR ", "PGM", _plist);
			
			
			System.out.println("Committing...");
			
			_plist=new ProgramParameter[1];
			text400=new AS400Text(10);
			_plist[0]=new ProgramParameter(text400.toBytes("COMMIT    "));
			
			CallPGM(as400, "KAPBASELIB", "Q02HSR ", "PGM", _plist);
			

				System.out.println("Setting up Commitment control envrionment...");
				
				_plist=new ProgramParameter[1];
				text400=new AS400Text(10);
				_plist[0]=new ProgramParameter(text400.toBytes("EQCCEND   "));
				
				CallPGM(as400, "KAPBASELIB", "Q02HSR ", "PGM", _plist);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		as400.disconnectAllServices();
	}
	
	private static void PostEntry(String sUser,byte[] arr){

		_plist=new ProgramParameter[13];

		_plist[0]=new ProgramParameter(new AS400Text(10).toBytes("H15ARR    "));
		_plist[1]=new ProgramParameter(new AS400Text(4).toBytes("SHO "));
		_plist[2]=new ProgramParameter(new AS400Text(4).toBytes(sUser.substring(0,4)));
		_plist[3]=new ProgramParameter(new AS400Text(4).toBytes("ISKZ"));
		_plist[4]=new ProgramParameter(new AS400Text(1).toBytes("A"));
		
		_plist[5]=new ProgramParameter(arr,9999);
		
		_plist[6]=new ProgramParameter(1);
		_plist[7]=new ProgramParameter(37);
		_plist[8]=new ProgramParameter(740);
		_plist[9]=new ProgramParameter(4);
		_plist[10]=new ProgramParameter(7);
		_plist[11]=new ProgramParameter(1);
		_plist[12]=new ProgramParameter(1);
		
		
		System.out.println("Source:\n"+((String)new AS400Text(arr.length).toObject(arr)));
		
		CallPGM(as400, "*LIBL     ", "H56HSR", "PGM", _plist);
		
		if (_rrec){
			
			byte[] rVal=_plist[6].getOutputData();
			AS400Text a400=new AS400Text(1);
			
			String rResult=(String)a400.toObject(rVal);
			System.out.println("Call result : "+rResult);
			
			if(rResult.equals("R")){
				_rval=true;
			}
			else{
				_rval=false;
				byte[] rMsg=_plist[7].getOutputData();
				AS400Text msg37=new AS400Text(37);
				System.out.println("Message : "+((String)msg37.toObject(rMsg)));
			}
			
			//a400=new AS400Text(37);
			//byte[] dsaim=_plist[7].getOutputData();
			
			//String x=(String)a400.toObject(dsaim);
			//System.out.println(x);
		}
	}
	
	private static void CallPGM(AS400 as400,String libName,String pgmName,String objType,ProgramParameter[] plist)
	{
		
		try {	
		
			ProgramCall pgm=new ProgramCall(as400);
			
			pgm.setProgram(QSYSObjectPathName.toPath(libName, pgmName, objType),plist);
			
			if(pgm.run()!=true)
			{
				AS400Message[] messages=pgm.getMessageList();
				int i=0;
				while (i<messages.length) {
					System.out.println(messages[i].getText());
					i++;
				}
				System.out.println("Call ended in error.");
				_rrec=false;
			}
			else
			{
				
				System.out.println("Call complete.");
				_rrec=true;
			}
		} catch (AS400SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ErrorCompletingRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObjectDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
