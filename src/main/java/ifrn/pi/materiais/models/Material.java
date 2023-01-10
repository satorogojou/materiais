package ifrn.pi.materiais.models;

import java.io.Serializable;
import java.time.LocalDate;
//import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Material implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

//	@NotEmpty
	private Long matricula;
//	@NotEmpty
	private String nome;
//	@NotEmpty
	private Long quantidade;
//	@NotEmpty
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
//	@NotEmpty
	private String horarioemp;
//	@NotEmpty
	private String horariodev;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getHorarioemp() {
		return horarioemp;
	}

	public void setHorarioemp(String horarioemp) {
		this.horarioemp = horarioemp;
	}

	public String getHorariodev() {
		return horariodev;
	}

	public void setHorariodev(String horariodev) {
		this.horariodev = horariodev;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Material [codigo=" + codigo + ", matricula=" + matricula + ", nome=" + nome + ", quantidade="
				+ quantidade + ", data=" + data + ", horarioemp=" + horarioemp + ", horariodev=" + horariodev + "]";
	}
}
