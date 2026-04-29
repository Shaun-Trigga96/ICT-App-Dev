<script language="javascript" type="text/javascript">
            var text="";
            var i;
            var testMark=100;
            var passMark=50;
            var outstandingMark=0;
             var Names= ["Chris", "Shaun", "Patrick", "Drake", "John"];
              var Marks= [90,80,70,60,0];
                document.write("<table>");
                 document.write("<tr>");
                   document.write("<th>Names</th>");
                    document.write("<th>Marks</th>");
                     document.write("</tr>");
            
                     for(i=0; i < Marks.length; i++){
                   document.write("<tr>");
                 document.write("<td>" + Names[i] + "</td>");
                 document.write("<td>" + Marks[i] + "</td>");
            document.write("</tr>");
           }
                
          document.write("</table>");
         document.getElementById("Student Marks").innerHTML = text;
</script>  