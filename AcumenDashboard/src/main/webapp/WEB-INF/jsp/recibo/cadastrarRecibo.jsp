<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../menu/menu.jsp"/>
<title>Acumen</title>
	<div class="content-wrapper">
	
		<section class="content">
			
			<div class="box box-primary">
                <div class="box-header with-border">
                  <h3 class="box-title">Cadastrar Recibo</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                <form role="form" action="salvarRecibo" method="post"  enctype="multipart/form-data"> 
                  <div class="box-body">
                    <div class="form-group">
                      	<label for="exampleInputPassword1">Categoria</label>
	                     <select class="form-control select2" style="width: 100%;" name="recibo.categoria">
	                     	<c:forEach items="${categorias}" var="categoria">
	                     		<option>${categoria}</option>
	                     	</c:forEach>
	                    </select>
                    </div>
                    <div class="form-group">
                      	<label for="exampleInputPassword1">Centro de Custo</label>
	                     <select class="form-control select2" style="width: 100%;" name="recibo.centroCusto">
	                     	<c:forEach items="${centros}" var="centro">
	                     		<option>${centro}</option>
	                     	</c:forEach>
	                    </select>
                    </div>
                    
                   <div class="form-group">
                      <label for="exampleInputEmail1">Valor</label>
                      <input type="price" name="recibo.valor" class="form-control" id="exampleInputEmail1" placeholder="Digite o valor">
                    </div>
                    
                    <div class="form-group">
                      <label for="exampleInputFile">Arquivo</label>
                      <input type="file" id="exampleInputFile" name="imgRecibo">
                    </div>
                  </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Enviar</button>
                  </div>
                </form>
              </div><!-- /.box -->
              
        </section>
	</div>

<jsp:include page="../menu/rodape.jsp"/>