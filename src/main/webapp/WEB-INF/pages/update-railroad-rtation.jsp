<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<body>

<table style="width:100%">
  <tr>
    <th>Title Railroad Station</th>
    <th>Id</th>
  </tr>
  <c:forEach items="${railroadStations}" var="railroadStation">
     <tr>
         <td>${railroadStation.title}</td>
         <td>${railroadStation.id}</td>
       </tr>
  </c:forEach>
</table>
<p>Count Railroad Station : ${countStations}</p>
<p>Summary Time  : ${timeInSec}</p>

</body>
</html>