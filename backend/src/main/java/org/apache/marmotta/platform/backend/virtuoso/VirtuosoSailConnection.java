package org.apache.marmotta.platform.backend.virtuoso;

import info.aduna.iteration.CloseableIteration;
import org.openrdf.model.*;
import org.openrdf.query.BindingSet;
import org.openrdf.query.Dataset;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.algebra.TupleExpr;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.sail.SailException;
import org.openrdf.sail.helpers.NotifyingSailConnectionBase;
import org.openrdf.sail.helpers.SailBase;

/**
 * Virtuoso Notifying SailConnection
 *
 * @author Sergio Fernández
 */
public class VirtuosoSailConnection extends NotifyingSailConnectionBase {

    RepositoryConnection conn;

    public VirtuosoSailConnection(SailBase sail, RepositoryConnection conn) {
        super(sail);
        this.conn = conn;
    }

    @Override
    protected void closeInternal() throws SailException {
        try {
            conn.close();
        } catch (RepositoryException e) {
            throw new SailException(e);
        }
    }

    @Override
    protected CloseableIteration<? extends BindingSet, QueryEvaluationException> evaluateInternal(TupleExpr tupleExpr, Dataset dataset, BindingSet bindings, boolean includeInferred) throws SailException {
        throw new RuntimeException("not implemented");
    }

    @Override
    protected CloseableIteration<? extends Resource, SailException> getContextIDsInternal() throws SailException {
        throw new RuntimeException("not implemented");
    }

    @Override
    protected CloseableIteration<? extends Statement, SailException> getStatementsInternal(Resource subj, URI pred, Value obj, boolean includeInferred, Resource... contexts) throws SailException {
        throw new RuntimeException("not implemented");
    }

    @Override
    protected long sizeInternal(Resource... contexts) throws SailException {
        try {
            return conn.size(contexts);
        } catch (RepositoryException e) {
            throw new SailException(e);
        }
    }

    @Override
    protected void startTransactionInternal() throws SailException {
        // wrapped connection is Sesame 2.6, no begin method
    }

    @Override
    protected void commitInternal() throws SailException {
        try {
            conn.commit();
        } catch (RepositoryException e) {
            throw new SailException(e);
        }
    }

    @Override
    protected void rollbackInternal() throws SailException {
        try {
            conn.rollback();
        } catch (RepositoryException e) {
            throw new SailException(e);
        }
    }

    @Override
    protected void addStatementInternal(Resource subj, URI pred, Value obj, Resource... contexts) throws SailException {
        try {
            conn.add(subj, pred, obj, contexts);
        } catch (RepositoryException e) {
            throw new SailException(e);
        }
    }

    @Override
    protected void removeStatementsInternal(Resource subj, URI pred, Value obj, Resource... contexts) throws SailException {
        try {
            conn.remove(subj, pred, obj, contexts);
        } catch (RepositoryException e) {
            throw new SailException(e);
        }
    }

    @Override
    protected void clearInternal(Resource... contexts) throws SailException {
        try {
            conn.clear(contexts);
        } catch (RepositoryException e) {
            throw new SailException(e);
        }
    }

    @Override
    protected CloseableIteration<? extends Namespace, SailException> getNamespacesInternal() throws SailException {
        throw new RuntimeException("not implemented");
    }

    @Override
    protected String getNamespaceInternal(String prefix) throws SailException {
        try {
            return conn.getNamespace(prefix);
        } catch (RepositoryException e) {
            throw new SailException(e);
        }
    }

    @Override
    protected void setNamespaceInternal(String prefix, String name) throws SailException {
        try {
            conn.setNamespace(prefix, name);
        } catch (RepositoryException e) {
            throw new SailException(e);
        }
    }

    @Override
    protected void removeNamespaceInternal(String prefix) throws SailException {
        try {
            conn.removeNamespace(prefix);
        } catch (RepositoryException e) {
            throw new SailException(e);
        }
    }

    @Override
    protected void clearNamespacesInternal() throws SailException {
        try {
            conn.clearNamespaces();
        } catch (RepositoryException e) {
            throw new SailException(e);
        }
    }

}
