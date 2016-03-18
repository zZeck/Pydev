// Autogenerated AST node
package org.python.pydev.parser.jython.ast;

import org.python.pydev.parser.jython.SimpleNode;
import java.util.Arrays;

public final class Print extends stmtType {
    public exprType dest;
    public exprType[] values;
    public boolean nl;

    public Print(exprType dest, exprType[] values, boolean nl) {
        this.dest = dest;
        this.values = values;
        this.nl = nl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dest == null) ? 0 : dest.hashCode());
        result = prime * result + Arrays.hashCode(values);
        result = prime * result + (nl ? 17 : 137);
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
        Print other = (Print) obj;
        if (dest == null) {
            if (other.dest != null)
                return false;
        } else if (!dest.equals(other.dest))
            return false;
        if (!Arrays.equals(values, other.values))
            return false;
        if (this.nl != other.nl)
            return false;
        return true;
    }

    @Override
    public Print createCopy() {
        return createCopy(true);
    }

    @Override
    public Print createCopy(boolean copyComments) {
        exprType[] new0;
        if (this.values != null) {
            new0 = new exprType[this.values.length];
            for (int i = 0; i < this.values.length; i++) {
                new0[i] = (exprType) (this.values[i] != null ? this.values[i].createCopy(copyComments) : null);
            }
        } else {
            new0 = this.values;
        }
        Print temp = new Print(dest != null ? (exprType) dest.createCopy(copyComments) : null, new0, nl);
        temp.beginLine = this.beginLine;
        temp.beginColumn = this.beginColumn;
        if (this.specialsBefore != null && copyComments) {
            for (Object o : this.specialsBefore) {
                if (o instanceof commentType) {
                    commentType commentType = (commentType) o;
                    temp.getSpecialsBefore().add(commentType.createCopy(copyComments));
                }
            }
        }
        if (this.specialsAfter != null && copyComments) {
            for (Object o : this.specialsAfter) {
                if (o instanceof commentType) {
                    commentType commentType = (commentType) o;
                    temp.getSpecialsAfter().add(commentType.createCopy(copyComments));
                }
            }
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Print[");
        sb.append("dest=");
        sb.append(dumpThis(this.dest));
        sb.append(", ");
        sb.append("values=");
        sb.append(dumpThis(this.values));
        sb.append(", ");
        sb.append("nl=");
        sb.append(dumpThis(this.nl));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Object accept(VisitorIF visitor) throws Exception {
        return visitor.visitPrint(this);
    }

    @Override
    public void traverse(VisitorIF visitor) throws Exception {
        if (dest != null) {
            dest.accept(visitor);
        }
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] != null) {
                    values[i].accept(visitor);
                }
            }
        }
    }

}
