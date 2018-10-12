package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;


@Embeddable
public class RatePk implements Serializable {
	
		private int idAction ;
		private int idVolenteer;
		
		public int getIdAction() {
			return idAction;
		}
		public void setIdAction(int idAction) {
			this.idAction = idAction;
		}
		public int getIdVolenteer() {
			return idVolenteer;
		}
		public void setIdVolenteer(int idVolenteer) {
			this.idVolenteer = idVolenteer;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idAction;
			result = prime * result + idVolenteer;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RatePk other = (RatePk) obj;
			if (idAction != other.idAction)
				return false;
			if (idVolenteer != other.idVolenteer)
				return false;
			return true;
		}
		
	
		
}
