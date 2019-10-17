/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Cidade;
import java.sql.Date;
import  java.time.format.DateTimeFormatter; 
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

        /**
 *
 * @author Administrador
 */
public class DaoCidade {
     public static boolean inserir(Cidade objeto) {
        String sql = "INSERT INTO cidade (codigo, nome, s_estado, n_habitantes, d_emancipacao, a_total, d_capital) VALUES (?, ?, ?, ?, ?, ?, ? )";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.setString(2, objeto.getNome());
            ps.setString(3, objeto.getS_estado());
            ps.setInt(4, objeto.getN_habitantes());
            ps.setDate(5, Date.valueOf(objeto.getD_emancipacao())); 
            ps.setDouble(6, objeto.getA_total());
            ps.setInt(7, objeto.getD_capital());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     public static void main(String[] args) {
        Cidade objeto = new Cidade();
        objeto.setCodigo(1);
        objeto.setNome("Ibirubá");
        objeto.setS_estado("RS");
        objeto.setN_habitantes(19310);
        objeto.setD_emancipacao(LocalDate.parse("28/02/1955", DateTimeFormatter.ofPattern("dd/MM/yyyy"))); 
        objeto.setA_total(618.80);
        objeto.setD_capital(296);
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
      public static boolean alterar(Cidade objeto) {
        String sql = "UPDATE cidade SET nome = ?, s_estado = ?, n_habitantes = ?, d_emancipacao = ?, a_total = ?, d_capital = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome()); 
            ps.setString(2, objeto.getS_estado());
            ps.setInt(3, objeto.getN_habitantes());
            ps.setDate(4, Date.valueOf(objeto.getD_emancipacao())); 
            ps.setDouble(5, objeto.getA_total());
            ps.setInt(6, objeto.getD_capital());
            ps.setInt(7, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
        public static boolean excluir(Cidade objeto) {
        String sql = "DELETE FROM cidade WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
        public static List<Cidade> consultar() {
        List<Cidade> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, s_estado, n_habitantes, d_emancipacao, a_total, d_capital FROM cidade";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidade objeto = new Cidade();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setS_estado(rs.getString("s_estado"));
                objeto.setN_habitantes(rs.getInt("n_habitantes"));
                objeto.setD_emancipacao(rs.getDate("d_emancipacao").toLocalDate());
                objeto.setA_total(rs.getDouble("a_total"));
                objeto.setD_capital(rs.getInt("d_capital"));
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
         public static Cidade consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, s_estado, n_habitantes, d_emancipacao, a_total, d_capital FROM cidade WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidade objeto = new Cidade();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setS_estado(rs.getString("s_estado"));
                objeto.setN_habitantes(rs.getInt("n_habitantes"));
                objeto.setD_emancipacao(rs.getDate("d_emancipacao").toLocalDate());
                objeto.setA_total(rs.getDouble("a_total"));
                objeto.setD_capital(rs.getInt("d_capital"));
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
