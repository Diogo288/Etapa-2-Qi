<%@page import="model.Tarefa"%>
<%@include file="session/validar.jsp" %>
<%
    Tarefa t = (Tarefa)request.getAttribute("task");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> WEB III </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="icon" href="img/logotipo.png" />
        <style>
            /* Configurações de estilo */
            body {
                background-color: green; /* Fundo verde */
                color: white; /* Texto branco */
            }

            h1 {
                color: white; /* Título branco */
            }

            .form-control {
                background-color: #f8f9fa; /* Fundo claro nos campos */
                color: black; /* Texto preto */
            }

            .form-control:focus {
                border-color: #28a745; /* Borda verde */
                box-shadow: 0 0 5px #28a745;
            }

            .btn {
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="mt-4 text-center container col-sm-10 col-md-6">
            <h1>Editar tarefa</h1>

            <form action="tarefa-controller" method="post" class="validar" novalidate onsubmit="return confirm('Deseja atualizar a tarefa?')">
                <input type="hidden" name="pagina" value="atualizar" />
                <input type="hidden" name="id" value="<%= t.getId() %>" />

                <div class="form-floating mt-3">
                    <input type="text" id="titulo" name="titulo" value="<%= t.getTitulo() %>" class="form-control" placeholder="Título da tarefa" required />
                    <label for="nome"> Título da tarefa </label>
                    <small class="invalid-feedback text-start">
                        Este campo é obrigatório.
                    </small>
                </div>

                <div class="form-floating mt-3">
                    <textarea id="descricao" name="descricao" class="form-control" placeholder="Descrição da tarefa"><%= t.getDescricao() %></textarea>
                    <label for="descricao"> Descrição </label>
                </div>

                <div class="mt-4 text-start">
                    <label>Status da tarefa</label>
                    <hr />
                    <div class="form-check">
                        <label for="a-fazer" class="form-check-label"> A fazer </label>
                        <input type="radio" id="a-fazer" name="status" value="A fazer" class="form-check-input"
                               <%= t.getStatusTarefa().equals("A fazer") ? "checked" : "" %> />
                    </div>

                    <div class="form-check">
                        <label for="em-andamento" class="form-check-label"> Em andamento </label>
                        <input type="radio" id="em-andamento" name="status" value="Em andamento" class="form-check-input"
                               <%= t.getStatusTarefa().equals("Em andamento") ? "checked" : "" %> />
                    </div>

                    <div class="form-check">
                        <label for="concluido" class="form-check-label"> Concluído </label>
                        <input type="radio" id="concluido" name="status" value="Concluído" class="form-check-input"
                               <%= t.getStatusTarefa().equals("Concluído") ? "checked" : "" %> />
                    </div>
                </div>

                <hr />

                <div class="d-grid mt-4">
                    <input type="submit" value="Atualizar" class="btn btn-success" />
                    <input type="reset" value="Restaurar dados" class="btn btn-outline-danger mt-3" />
                </div>
            </form>
        </div>

        <script src="js/bootstrap.min.js"></script>
        <script>
            function pegarData() {
                let hoje = new Date();
                let dataFormatada =
                    hoje.getFullYear() - 12 +
                    "-" +
                    (hoje.getMonth() + 1 < 10 ? "0" : "") +
                    (hoje.getMonth() + 1) +
                    "-" +
                    (hoje.getDate() < 10 ? "0" : "") +
                    hoje.getDate();
                document.getElementById("nasc").max = dataFormatada;
            }

            document.addEventListener("load", pegarData());
        </script>

        <script src="js/init-validation.js"></script>
    </body>
</html>
