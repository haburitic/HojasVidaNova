package com.nova.MsHv.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.entidad.ContactoHseq;
import com.nova.MsHv.impl.ContactoHseqImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;
import com.nova.MsHvExcepciones.NovaHVRestException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @contactHseq enlaRed.co
 * @version 1.0
 */
public class ContactHseqRestController {
	static final Logger log = Logger.getLogger(ContactHseqRestController.class);
	@Autowired
	ContactoHseqImpl contactHseqDAO;



	@RequestMapping(value = "contactoHseq/find", method = RequestMethod.POST)
	@ResponseBody	
	public List<ContactoHseq> getContactosCliente(@RequestBody ContactoHseq contacto) throws NovaHVDaoException {
		List<ContactoHseq> contactHseq= new ArrayList<>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in ContactHseq");
		try {

			contactHseq = contactHseqDAO.consultarAll(contacto);
			if (!contactHseq.equals(null)) {

				log.info("Log4j get the ContactHseq with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for contactHseq " + e);
			throw new NovaHVDaoException(e);

		}

		return contactHseq;
	}

	
	
/**
	 * Method for Save one new contactHseq
	 * 
	 * @param data
	 *            for the new contactHseq
 * @return 
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "contactoHseq/save", method = RequestMethod.POST)
	@ResponseBody
	public ContactoHseq setContactHseq(@RequestBody ContactoHseq contactHseq) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for contactHseq");
		try {
			return contactHseqDAO.save(contactHseq);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for contactHseq " + e);
			throw new NovaHVRestException(e);

		}

	}

	@RequestMapping(value = "contactoHseq/delete", method = RequestMethod.POST)
	@ResponseBody
	public boolean remove(@RequestBody ContactoHseq contactHseq) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method remove for contactHseq");
		try {
			contactHseqDAO.remove(contactHseq);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method remove for contactHseq " + e);
			throw new NovaHVRestException(e);

		}

	}

}
