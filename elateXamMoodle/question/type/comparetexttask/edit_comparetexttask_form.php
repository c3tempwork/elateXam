<?php
// This file is part of Moodle - http://moodle.org/
//
// Moodle is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Moodle is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Moodle.  If not, see <http://www.gnu.org/licenses/>.

/**
 * Defines the editing form for the comparetexttask question type.
 *
 * @package    qtype
 * @subpackage comparetexttask
 * @license    http://www.gnu.org/copyleft/gpl.html GNU Public License
 */


defined('MOODLE_INTERNAL') || die();

/**
 * comparetexttask editing form definition.
 *
 * @license    http://www.gnu.org/copyleft/gpl.html GNU Public License
*/
class qtype_comparetexttask_edit_form extends question_edit_form {
	protected function definition_inner($mform) {
		// this method is called by question_edit_form.definition() 
		global $CFG;
		global $PAGE;
		// a) We need a Corrector Feedback Field for all ComplexTask questions, see question_edit_form.definition()
		$element = $mform->addElement('editor', 'correctorfeedback', "Feedback for the Corrector", array('rows' => 10), $this->editoroptions);
		//$mform->setDefault('correctorfeedback', ...); // doesn't work for "editor" fields (blame moodle for this)
		$element->setValue(array('text'=>$this->get_correctorfeedback())); // see https://github.com/colchambers/moodle/commit/MDL-31726
		$mform->setType('correctorfeedback', PARAM_RAW);

		// b) Java Applet
		$jarfile = "compareTextTask.jar";
		$jarpath = $CFG->wwwroot . "/question/type/" . $this->qtype() . "/lib/" . $jarfile;
		$innerpath = "com/spiru/dev/compareTextTask_addon/CompareTextProfessorApplet.class";
		$appletstr = "\n\n<applet "
				. 'archive="' . $jarpath . '" ' . 'code="'. $innerpath . '" '
				. 'id="appletField"'
				. 'width="600" height="400">\n'
			. '<param name="initialText" value="' . $this->get_initial_text() . '">\n'
			. '<param name="xmlDef" value="' . $this->get_avaiable_tags() . '">\n'
			. '<param name="sampleSolution" value="' . $this->get_sample() . '">\n'
			. "</applet>\n\n";

		// Trick to place it at the same position as the <input> elements above it (+ nice label)
		$appletstr = '<div class="fitem fitem_feditor" id="fitem_id_questiontext"><div class="fitemtitle"><label for="appletField">Settings for CompareTextTask</label></div>'
				.'<div class="felement feditor"><div><div>'.$appletstr.'</div></div></div></div>';

		// Hidden Elements to put in the Applet output via module.js
		$failstr = "Error: Applet Content was not send!"; // result when javascript didn't execute properly 
		$mform->addElement('textarea', 'initial_text', '', 'style="display:none;"');
		$mform->addElement('textarea', 'avaiable_tags', '', 'style="display:none;"');
		$mform->addElement('textarea', 'sample', '', 'style="display:none;"');
		$mform->setDefault('initial_text', $failstr);
		$mform->setDefault('avaiable_tags', $failstr);
		$mform->setDefault('sample', $failstr);

		// Finaly add Applet to form
		$mform->addElement('html', $appletstr);

		// c) Add Module.js
		$PAGE->requires->js("/question/type/" . $this->qtype() . "/jquery-1.8.0.min.js");
		$PAGE->requires->js("/question/type/" . $this->qtype() . "/module.js");
	}

	public function qtype() {
		return 'comparetexttask';
	}

	protected function get_correctorfeedback() {
		if (property_exists($this->question, "options")) // when updating
			return $this->question->options->correctorfeedback;
		return ""; // when inserting
	}

	protected function get_initial_text() {
		if (property_exists($this->question, "options")) // when updating
			return $this->question->options->initialtext;
		return ""; // when inserting
	}

	protected function get_avaiable_tags() {
		if (property_exists($this->question, "options")) // when updating
			return $this->question->options->avaiabletags;
		return ""; // when inserting
	}

	protected function get_sample() {
		if (property_exists($this->question, "options")) // when updating
			return $this->question->options->sample;
		return ""; // when inserting
	}

	protected function get_xml_tags() {
		return "<some><xml></xml></some>";
	}
}