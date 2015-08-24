<html>
  <head>
    <meta name="layout" content="main" />
    <title>Login</title>
  </head>
  <body>
      <div id="page-body" role="main" style="padding-left: 80px">
      <h1>Login</h1>
      
      <g:if test="${flash.message}" >
          <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only"></span>
                ${flash.message}
          </div>
      </g:if>
      <g:form action="authenticate" method="post" >
        <div class="dialog">
          <table>
            <tbody>
              <tr class="prop">
                <td class="name">
                  <label for="login">Login:</label>
                </td>
                <td>
                  <input type="text" id="login" name="login"/>
                </td>
              </tr>

              <tr class="prop">
                <td class="name">
                  <label for="password">Senha:</label>
                </td>
                <td>
                  <input type="password" id="password" name="password"/>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="buttons">
          <span class="button">
            <input class="save" type="submit" value="Login" />
          </span>
        </div>
      </g:form>
    </div>
  </body>
</html>
