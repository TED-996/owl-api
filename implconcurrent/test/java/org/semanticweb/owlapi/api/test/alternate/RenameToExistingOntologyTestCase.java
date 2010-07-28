package org.semanticweb.owlapi.api.test.alternate;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyRenameException;
import org.semanticweb.owlapi.model.SetOntologyID;

/*
 * Copyright (C) 2009, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
/**
 * Author: Matthew Horridge<br>
 * The University of Manchester<br>
 * Information Management Group<br>
 * Date: 22-Dec-2009
 */
public class RenameToExistingOntologyTestCase extends AbstractOWLAPITestCase {
	public void testRenameToExistingOntology() throws Exception {
		try {
			OWLOntologyManager manager = getManager();
			IRI ontologyAIRI = IRI
					.create("http://www.semanticweb.org/ontologies/ontologyA");
			OWLOntology ontologyA = manager.createOntology(ontologyAIRI);
			IRI ontologyBIRI = IRI
					.create("http://www.semanticweb.org/ontologies/ontologyB");
			OWLOntology ontologyB = manager.createOntology(ontologyBIRI);
			manager.applyChange(new SetOntologyID(ontologyB, new OWLOntologyID(
					ontologyAIRI)));
			fail();
		} catch (OWLOntologyRenameException e) {
			System.out.println("Got expected rename exception: "
					+ e.getMessage());
		}
	}
}