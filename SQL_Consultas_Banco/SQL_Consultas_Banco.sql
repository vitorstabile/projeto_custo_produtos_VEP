/*Juncao das tabelas Produto, Receita, Recurso e Embalagem*/

SELECT custo_produtos.produto.idProduto,
custo_produtos.produto.descricaoProduto,
custo_produtos.produto.baseCalcProduto,
custo_produtos.produto.gramaturaProduto,
custo_produtos.produto.rendBrutoProduto,
custo_produtos.produto.custoProduto,
custo_produtos.produto.dataProduto,
custo_produtos.receita.idReceita,
custo_produtos.receita.descricaoReceita,
custo_produtos.teste.gramaturaTeste,
custo_produtos.receita.rendLiqReceita,
custo_produtos.receita.rendBrutoReceita,
custo_produtos.receita.perdaReceita,
custo_produtos.receita.custoReceita,
custo_produtos.receita.dataReceita,
custo_produtos.embalagem.id_Produto_MP_PK,
custo_produtos.mp.idMP,
custo_produtos.mp.codigoMP,
custo_produtos.mp.descricaoMP,
custo_produtos.mp.custoMP,
custo_produtos.embalagem.qtEmbalagem,
custo_produtos.embalagem.custoEmbalagem,
custo_produtos.utilidade.id_Produto_Recurso_PK,
custo_produtos.recurso.idRecurso,
custo_produtos.recurso.descricaoRecurso,
custo_produtos.recurso.custoRecurso
FROM custo_produtos.produto
INNER JOIN custo_produtos.teste
ON custo_produtos.teste.idProduto = custo_produtos.produto.idProduto
INNER JOIN custo_produtos.receita
ON custo_produtos.teste.idReceita = custo_produtos.receita.idReceita
INNER JOIN custo_produtos.embalagem
ON custo_produtos.produto.idProduto = custo_produtos.embalagem.idProduto
INNER JOIN custo_produtos.mp
ON custo_produtos.mp.idMP = custo_produtos.embalagem.idMP
INNER JOIN custo_produtos.utilidade
ON custo_produtos.utilidade.idProduto = custo_produtos.produto.idProduto
INNER JOIN custo_produtos.recurso
ON custo_produtos.recurso.idRecurso = custo_produtos.utilidade.idRecurso
WHERE custo_produtos.produto.idProduto = 2;