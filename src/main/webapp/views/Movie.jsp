
<!DocTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-EDGE">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Movie List</title>
        <style>
            table,
            th,
            td {
                border: 1px solid black;
            }
        </style>
    </head>

    <body>
        <h1>Movie List</h1>
        <table>
            <tr>
                <th>ID Phim</th>
                <th>Ten Phim</th>
                <th>Ngay Cong Chieu</th>
                <th>Ngay Ket Thuc</th>
                <th>Option</th>
            </tr>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td>${movie.movieId}</td>
                    <td>${movie.movieName}</td>
                    <td>${movie.releaseDate}</td>
                    <td>${movie.endDate}</td>
                    <td><a>Chi Tiet</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>