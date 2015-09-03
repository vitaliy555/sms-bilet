<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<body>

<table style="width:100%">
  <tr>
    <th>Title Station</th>
    <th>Id</th>
  </tr>
  <c:forEach items="${stations}" var="station">
     <tr>
                  <td>${station.id}</td>
<td>${station.title}</td>
       </tr>
  </c:forEach>
</table>
<p>Count Railroad Station : ${countStations}</p>
<p>Summary Time  : ${timeInSec}</p>

</body>
</html>