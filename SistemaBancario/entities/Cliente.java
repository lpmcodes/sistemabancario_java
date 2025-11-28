package entities;

public class Cliente {
    private String cpf; // Declarando o atributo (o que é cpf -> no caso é tipo String)
    private String nome;
    private String email;
    
    public Cliente(String cpf, String nome, String email) {
        this.cpf = cpf; // Atributo cpf recebe o parâmetro cpf
        this.nome = nome;
        this.email = email;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) { // public torna o método acessível por qualquer classe; void não retorna nenhum valor; String nome recebe um parâmetro chamado "nome"
        if (nome != null && !nome.trim().isEmpty()) { // o símoblo ! significa que se ele for diferente de ... tal ação acontece; trim remove espaços no início e no fim
            this.nome = nome;
            /* ex: Cliente cliente = new Cliente();

                cliente.setNome("João Silva");     // ✅ Válido - atribui "João Silva"
                cliente.setNome("  Maria  ");      // ✅ Válido - atribui "Maria" (trim remove espaços)
                cliente.setNome(null);             // ❌ Não atribui (evita NullPointerException)
                cliente.setNome("");               // ❌ Não atribui (string vazia)
                cliente.setNome("     ");          // ❌ Não atribui (só espaços)
            */
        }
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        }
    }
    
    @Override // utilizado para quando vc for sobrescrever um método -> boa prática
    public String toString() {
        return "Cliente{cpf='" + cpf + "', nome='" + nome + "', email='" + email + "'}";
    }
}

