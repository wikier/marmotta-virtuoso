package org.apache.marmotta.platform.backend.virtuoso;

import net.fortytwo.sesametools.reposail.RepositorySail;
import org.openrdf.model.ValueFactory;
import org.openrdf.repository.Repository;
import org.openrdf.sail.*;
import org.openrdf.sail.helpers.NotifyingSailBase;

import java.util.HashSet;
import java.util.Set;

/**
 * Notifying Sail Wrapper
 *
 * @author Sergio Fernández
 */
public class NotifyingSailWrapper extends NotifyingSailBase implements NotifyingSail {

        private Sail sail;

        private Set<SailChangedListener> sailChangedListeners = new HashSet<>(0);

        /**
         * Create a wrapper from a Sail
         *
         */
        public NotifyingSailWrapper(Sail sail) {
            this.sail = sail;
        }

        /**
         * Create a wrapper from a Repository
         *
         */
        public NotifyingSailWrapper(Repository repository) {
            this(new RepositorySail(repository));
        }

        /**
         * Adds the specified SailChangedListener to receive events when the data in
         * this Sail object changes.
         */
        @Override
        public void addSailChangedListener(SailChangedListener listener) {
            synchronized (sailChangedListeners) {
                sailChangedListeners.add(listener);
            }
        }

        /**
         * Removes the specified SailChangedListener so that it no longer receives
         * events from this Sail object.
         */
        @Override
        public void removeSailChangedListener(SailChangedListener listener) {
            synchronized (sailChangedListeners) {
                sailChangedListeners.remove(listener);
            }
        }

        /**
        * Notifies all registered SailChangedListener's of changes to the contents
        * of this Sail.
        */
        @Override
        public void notifySailChanged(SailChangedEvent event) {
            synchronized (sailChangedListeners) {
                for (SailChangedListener l : sailChangedListeners) {
                    l.sailChanged(event);
                }
            }
        }

        @Override
        public void initialize() throws SailException {
            sail.initialize();
        }

        @Override
        protected NotifyingSailConnection getConnectionInternal() throws SailException {
            return this.getConnection();
        }

        /**
         * Do store-specific operations to ensure proper shutdown of the store.
         */
        @Override
        protected void shutDownInternal() throws SailException {
            sail.shutDown();
        }

        /**
         * Checks whether this Sail object is writable, i.e. if the data contained in
         * this Sail object can be changed.
         */
        @Override
        public boolean isWritable() throws SailException {
            return sail.isWritable();
        }

        /**
         * Gets a ValueFactory object that can be used to create URI-, blank node-,
         * literal- and statement objects.
         *
         * @return a ValueFactory object for this Sail object.
         */
        @Override
        public ValueFactory getValueFactory() {
            return sail.getValueFactory();
        }

}