<script language="javascript" type="text/javascript">
    var text="";
     var i;
       var testMark=100;
        var passMark=50;
          var outstandingMark=0;
            var Names= ["Chris", "Shaun", "Patrick", "Drake", "John"];
              var Marks= [90,80,70,60,0];
               
              for(i=0; i < Marks.length; i++){
              
            if (Marks[i] >= passMark){
          text+= "Student:" +"" + "" + "\t" + Names[i] + "" + "\t"+ Marks[i] +"\t" + "Pass" + "<br>";
        }
    else 
text+= "Student:" + "" + "\t" + Names[i] + "" + "\t" + Marks[i] +"\t" + "Fail" + "<br>";
        
if(Marks[i] === outstandingMark){
    
text+= "Student:" +""+ "\t" + Names[i] + "" + "\t" + Marks[i] + "\t" + "Mark is Outstanding" + "<br>";
}
}