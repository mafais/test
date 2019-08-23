package misys.api;

import com.ibm.as400.access.AS400PackedDecimal;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.AS400ZonedDecimal;

public class H15ARR {

	String GZWSID;
	int GZDIM; 
	int GZTIM; 
	int GZSEQ; 
	String GZIMG; 
	String GZAB;  
	String GZAN;  
	String GZAS;  
	String GZBRNM;
	String GZPBR; 
	int GZPSQ; 
	int GZVFR; 
	String GZBRND;
	String GZDRF; 
	long GZAMA;
	String GZAPP;
	String GZTCD;
	String GZCCY;
	String GZSRC;
	String GZUC1;
	String GZUC2;
	int GZNPE;
	String GZNR1;
	String GZNR2;
	String GZNR3;
	String GZNR4;
	String GZRFR;
	String GZAUT;
	String GZSSI; 
	String GZFRV; 
	String GZTTP;
	String GZHSRL;
	long GZHAMT;
	String GZAUTC;
	String GZCED; 
	String GZCHQ;
	long GZDRFN;
	String GZINW; 
	String GZRAU; 
	String GZEMN1;
	String GZRAU1;
	String GZEMN2;
	String GZRAU2;
	String GZEMN3;
	String GZRAU3;
	String GZEMN4;
	String GZRAU4;
	String GZMCH; 
	String GZTCCY;
	long GZTAMA;
	String GZTCED;
	String GZHCCY;
	String GZEAN; 
	String GZGDP; 
	int GZPSQ7;
	
	public H15ARR()
	{
		GZWSID = "ISKZ";
		GZDIM=0; 
		GZTIM=0; 
		GZSEQ=1; 
		GZIMG="A"; 
		GZAB="0";  
		GZAN="0";  
		GZAS="0";  
		GZBRNM="0";
		GZPBR=""; 
		GZPSQ=1; 
		GZVFR=0; 
		GZBRND="";
		GZDRF=""; 
		GZAMA=0;
		GZAPP="";
		GZTCD="";
		GZCCY="";
		GZSRC="";
		GZUC1="";
		GZUC2="";
		GZNPE=1;
		GZNR1="";
		GZNR2="";
		GZNR3="";
		GZNR4="";
		GZRFR="N";
		GZAUT="N";
		GZSSI=""; 
		GZFRV=""; 
		GZTTP="";
		GZHSRL="";
		GZHAMT=0;
		GZAUTC="";
		GZCED=""; 
		GZCHQ="";
		GZDRFN=0;
		GZINW="N"; 
		GZRAU=""; 
		GZEMN1="";
		GZRAU1="";
		GZEMN2="";
		GZRAU2="";
		GZEMN3="";
		GZRAU3="";
		GZEMN4="";
		GZRAU4="";
		GZMCH=""; 
		GZTCCY=GZCCY;
		GZTAMA=GZAMA;
		GZTCED=GZCED;
		GZHCCY="";
		GZEAN=""; 
		GZGDP="N"; 
		GZPSQ7=0;
		
		
	}
	
	public void set_GZWSID(String _value)
	{
		GZWSID=_value;
	}
	public void set_GZDIM(int _value)
	{
		GZDIM=_value;
	}
	public void set_GZTIM(int _value)
	{
		GZTIM=_value;
	}
	public void set_GZAB(String _value)
	{
		GZAB=_value;
	}
	public void set_GZAN(String _value)
	{
		GZAN=_value;
	}
	public void set_GZAS(String _value)
	{
		GZAS=_value;
	}
	public void set_GZBRNM(String _value)
	{
		GZBRNM=_value;
	}
	public void set_GZPBR(String _value)
	{
		GZPBR=_value;
	}
	public void set_GZVFR(int _value)
	{
		GZVFR=_value;
	}
	public void set_GZBRND(String _value)
	{
		GZBRND=_value;
	}
	public void set_GZDRF(String _value)
	{
		GZDRF=_value;
	}
	public void set_GZAMA(long _value)
	{
		GZAMA=_value;
		GZTAMA=Math.abs(_value);
	}
	public void set_GZTCD(String _value)
	{
		GZTCD=_value;
	}
	public void set_GZCCY(String _value)
	{
		GZCCY=_value;
		GZTCCY=_value;
	}
	public void set_GZNR1(String _value)
	{
		GZNR1=_value;
	}
	public void set_GZCED(String _value)
	{
		GZCED=_value;
		GZTCED=_value;
	}
	public void set_GZSEQ(int _value)
	{
		GZSEQ=_value;
		GZPSQ7= _value;
	}
	
	public byte[] GetStructure()
	{
		byte[] b_GZWSID = new AS400Text(4).toBytes(GZWSID);
		byte[] b_GZDIM=new AS400ZonedDecimal(2, 0).toBytes(GZDIM); 
		byte[] b_GZTIM=new AS400ZonedDecimal(6, 0).toBytes(GZTIM); 
		byte[] b_GZSEQ=new AS400PackedDecimal(7, 0).toBytes(GZSEQ);  
		byte[] b_GZIMG=new AS400Text(1).toBytes(GZIMG); 
		byte[] b_GZAB=new AS400Text(4).toBytes(GZAB);  
		byte[] b_GZAN=new AS400Text(6).toBytes(GZAN);  
		byte[] b_GZAS=new AS400Text(3).toBytes(GZAS);  
		byte[] b_GZBRNM=new AS400Text(4).toBytes(GZBRNM);
		byte[] b_GZPBR=new AS400Text(5).toBytes(GZPBR); 
		byte[] b_GZPSQ=new AS400PackedDecimal(5,0).toBytes(GZPSQ); 
		byte[] b_GZVFR=new AS400ZonedDecimal(7, 0).toBytes(GZVFR); 
		byte[] b_GZBRND=new AS400Text(4).toBytes(GZBRND);
		byte[] b_GZDRF=new AS400Text(16).toBytes(GZDRF); 
		byte[] b_GZAMA=new AS400PackedDecimal(15, 0).toBytes(GZAMA);
		byte[] b_GZAPP=new AS400Text(2).toBytes(GZAPP);
		byte[] b_GZTCD=new AS400Text(3).toBytes(GZTCD);
		byte[] b_GZCCY=new AS400Text(3).toBytes(GZCCY);
		byte[] b_GZSRC=new AS400Text(2).toBytes(GZSRC);
		byte[] b_GZUC1=new AS400Text(3).toBytes(GZUC1);
		byte[] b_GZUC2=new AS400Text(3).toBytes(GZUC2);
		byte[] b_GZNPE=new AS400PackedDecimal(5, 0).toBytes(GZNPE);
		//byte[] b_GZNR1=new AS400Text(35).toBytes(String.format("%35s", ""));
		byte[] b_GZNR1=new AS400Text(35).toBytes(GZNR1);
		byte[] b_GZNR2=new AS400Text(35).toBytes(GZNR2);
		byte[] b_GZNR3=new AS400Text(35).toBytes(GZNR3);
		byte[] b_GZNR4=new AS400Text(35).toBytes(GZNR4);
		byte[] b_GZRFR=new AS400Text(1).toBytes(GZRFR);
		byte[] b_GZAUT=new AS400Text(1).toBytes(GZAUT);
		byte[] b_GZSSI=new AS400Text(1).toBytes(GZSSI); 
		byte[] b_GZFRV=new AS400Text(1).toBytes(GZFRV); 
		byte[] b_GZTTP=new AS400Text(1).toBytes(GZTTP);
		byte[] b_GZHSRL=new AS400Text(16).toBytes(GZHSRL);
		byte[] b_GZHAMT=new AS400PackedDecimal(15, 0).toBytes(GZHAMT);
		byte[] b_GZAUTC=new AS400Text(12).toBytes(GZAUTC);
		byte[] b_GZCED=new AS400Text(1).toBytes(GZCED); 
		byte[] b_GZCHQ=new AS400Text(1).toBytes(GZCHQ);
		byte[] b_GZDRFN=new AS400PackedDecimal(16,0).toBytes(GZDRFN);
		byte[] b_GZINW=new AS400Text(1).toBytes(GZINW); 
		byte[] b_GZRAU=new AS400Text(1).toBytes(GZRAU); 
		byte[] b_GZEMN1=new AS400Text(4).toBytes(GZEMN1);
		byte[] b_GZRAU1=new AS400Text(1).toBytes(GZRAU1);
		byte[] b_GZEMN2=new AS400Text(4).toBytes(GZEMN2);
		byte[] b_GZRAU2=new AS400Text(1).toBytes(GZRAU2);
		byte[] b_GZEMN3=new AS400Text(4).toBytes(GZEMN3);
		byte[] b_GZRAU3=new AS400Text(1).toBytes(GZRAU3);
		byte[] b_GZEMN4=new AS400Text(4).toBytes(GZEMN4);
		byte[] b_GZRAU4=new AS400Text(1).toBytes(GZRAU4);
		byte[] b_GZMCH=new AS400Text(1).toBytes(GZMCH);
		byte[] b_GZTCCY=new AS400Text(3).toBytes(GZTCCY);
		byte[] b_GZTAMA=new AS400PackedDecimal(15, 0).toBytes(GZTAMA);
		byte[] b_GZTCED=new AS400Text(1).toBytes(GZTCED); 
		byte[] b_GZHCCY=new AS400Text(3).toBytes(GZHCCY); 
		byte[] b_GZEAN=new AS400Text(20).toBytes(GZEAN);  
		byte[] b_GZGDP=new AS400Text(1).toBytes(GZGDP); 
		byte[] b_GZPSQ7=new AS400PackedDecimal(7, 0).toBytes(GZPSQ7);
		
		return concat(b_GZWSID,b_GZDIM ,b_GZTIM ,b_GZSEQ ,b_GZIMG ,b_GZAB  ,b_GZAN  ,b_GZAS  ,b_GZBRNM,b_GZPBR ,b_GZPSQ ,b_GZVFR ,b_GZBRND,b_GZDRF ,b_GZAMA,b_GZAPP,b_GZTCD,b_GZCCY,b_GZSRC,b_GZUC1,b_GZUC2,b_GZNPE,b_GZNR1,b_GZNR2,b_GZNR3,b_GZNR4,b_GZRFR,b_GZAUT,b_GZSSI ,b_GZFRV ,b_GZTTP ,b_GZHSRL,b_GZHAMT,b_GZAUTC,b_GZCED ,b_GZCHQ ,b_GZDRFN,b_GZINW ,b_GZRAU ,b_GZEMN1,b_GZRAU1,b_GZEMN2,b_GZRAU2,b_GZEMN3,b_GZRAU3,b_GZEMN4,b_GZRAU4,b_GZMCH ,b_GZTCCY,b_GZTAMA,b_GZTCED,b_GZHCCY,b_GZEAN ,b_GZGDP ,b_GZPSQ7);
	
	}
	
	private static byte[] concat(byte[]...arrays){
	    // Determine the length of the result array
	    int totalLength = 0;
	    for (int i = 0; i < arrays.length; i++)
	    {
	        totalLength += arrays[i].length;
	    }

	    // create the result array
	    byte[] result = new byte[totalLength];

	    // copy the source arrays into the result array
	    int currentIndex = 0;
	    for (int i = 0; i < arrays.length; i++)
	    {
	        System.arraycopy(arrays[i], 0, result, currentIndex, arrays[i].length);
	        currentIndex += arrays[i].length;
	    }

	    return result;
	}	
	
	
}
