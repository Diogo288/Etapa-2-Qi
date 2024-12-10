<%-- 
    Document   : resultado
    Created on : 10 de dez. de 2024, 12:55:09
    Author     : Eu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ReciclaAqui - Resultado da Pesquisa</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="index.html">Sobre</a></li>
                <li><a href="unidades.html">Pesquisar</a></li>
                <li><a href="login.html">Fazer login</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="resultados">
            <h1>Resultados da Pesquisa</h1>
            <article class="resultado-item">
                <h2>Ponto de Reciclagem - Porto Alegre</h2>
                <p>Endereço: Av. Exemplo, 123 - Porto Alegre</p>
                <p>Resíduos Aceitos: Papel, Plástico, Alumínio, Vidro</p>
                <a href="#">Ver no mapa</a>
            </article>
            <article class="resultado-item">
                <h2>Cooperativa ReciclaSul</h2>
                <p>Endereço: Rua Modelo, 456 - Porto Alegre</p>
                <p>Resíduos Aceitos: Papel e Papelão, Plástico</p>
                <a href="#">Ver no mapa</a>
            </article>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 ReciclaAqui. Todos os direitos reservados.</p>
    </footer>

<div vw class="enabled">
    <div vw-access-button class="active"></div>
    <div vw-plugin-wrapper>
      <div class="vw-plugin-top-wrapper"></div>
    </div>
  </div>
  <script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
  <script>
    new window.VLibras.Widget('https://vlibras.gov.br/app');
  </script>
</body>
</html>
