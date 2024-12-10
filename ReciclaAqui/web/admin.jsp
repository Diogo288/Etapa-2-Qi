<%-- 
    Document   : admin
    Created on : 10 de dez. de 2024, 12:52:20
    Author     : Eu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ReciclaAqui - Administração</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
    <style>
        #map {
            height: 400px;
            width: 100%;
        }
    </style>
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
        <section class="admin-panel">
            <h1>Painel de Administração</h1>
            <p>Aqui você pode gerenciar as unidades cadastradas.</p>

            <div id="map"></div>

            <table>
                <thead>
                    <tr>
                        <th>CNPJ</th>
                        <th>Nome</th>
                        <th>Endereço</th>
                        <th>Resíduos Aceitos</th>
                        <th>Horário de Funcionamento</th>
                        <th>Contato</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>12.345.678/0001-99</td>
                        <td>Ponto de Reciclagem Porto Alegre</td>
                        <td>Av. Exemplo, 123 - Porto Alegre</td>
                        <td>Papel, Plástico</td>
                        <td>08:00 - 18:00</td>
                        <td>contato@email.com</td>
                        <td>
                            <button>Aprovar</button>
                            <button>Rejeitar</button>
                            <button>Excluir</button>
                        </td>
                    </tr>
                    <!-- Adicione mais linhas conforme necessário -->
                </tbody>
            </table>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 ReciclaAqui. Todos os direitos reservados.</p>
    </footer>

    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
    <script>
        window.onload = function() {
            var map = L.map('map').setView([-30.0346, -51.2177], 14);

            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);
        };
    </script>
</body>
</html>