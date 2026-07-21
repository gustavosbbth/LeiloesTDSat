/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */


import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        String sql = "INSERT INTO produtos(nome, valor, status) VALUES (?, ?, ?)";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);

        prep.setString(1, produto.getNome());
        prep.setInt(2, produto.getValor());
        prep.setString(3, produto.getStatus());

        prep.executeUpdate();

        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());

    }
        
      
    }
    
    public List<ProdutosDTO> listarProdutos(){
        
 

    List<ProdutosDTO> lista = new ArrayList<>();

    String sql = "SELECT * FROM produtos";

    try {
        conectaDAO conexao = new conectaDAO();
        Connection conn = conexao.connectDB();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {

            ProdutosDTO obj = new ProdutosDTO();

            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setValor(rs.getInt("valor"));
            obj.setStatus(rs.getString("status"));

            lista.add(obj);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}
    }
    
    
    
        


