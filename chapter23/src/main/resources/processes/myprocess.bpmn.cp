<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:activiti="http://activiti.org/bpmn" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:omgdc="http://www.omg.org/spec/DD/20100524/DC" xmlns:omgdi="http://www.omg.org/spec/DD/20100524/DI" xmlns:tns="http://www.activiti.org/test" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" expressionLanguage="http://www.w3.org/1999/XPath" id="m1556011618275" name="" targetNamespace="http://www.activiti.org/test" typeLanguage="http://www.w3.org/2001/XMLSchema">
  <process id="myProcess" isClosed="false" isExecutable="true" name="myProcess" processType="Public">
    <startEvent id="startEvent" name="开始"/>
    <serviceTask activiti:exclusive="true" id="serviceTask1" name="修改请假单状态"/>
    <sequenceFlow id="_4" name="flow1" sourceRef="startEvent" targetRef="serviceTask1"/>
    <userTask activiti:exclusive="true" id="userTask1" name="项目经理审批"/>
    <sequenceFlow id="_6" name="flow2" sourceRef="serviceTask1" targetRef="userTask1"/>
    <exclusiveGateway gatewayDirection="Unspecified" id="gateway1" name="Gateway"/>
    <userTask activiti:exclusive="true" id="userTask2" name="人事审批"/>
    <serviceTask activiti:exclusive="true" id="serviceTask3" name="修改请假单状态(reject)"/>
    <sequenceFlow id="_13" name="flow3" sourceRef="userTask1" targetRef="gateway1"/>
    <sequenceFlow id="_14" name="flow4" sourceRef="gateway1" targetRef="userTask2"/>
    <sequenceFlow id="_15" name="flow8" sourceRef="gateway1" targetRef="serviceTask3"/>
    <exclusiveGateway gatewayDirection="Unspecified" id="gatway2" name="Gateway2"/>
    <serviceTask activiti:exclusive="true" id="serviceTask2" name="修改请假单状态(pass)"/>
    <endEvent id="endTask" name="结束"/>
    <sequenceFlow id="_21" name="flow10" sourceRef="serviceTask3" targetRef="endTask"/>
    <sequenceFlow id="_22" name="flow5" sourceRef="userTask2" targetRef="gatway2"/>
    <sequenceFlow id="_23" name="flow6" sourceRef="gatway2" targetRef="serviceTask2"/>
    <sequenceFlow id="_24" name="flow7" sourceRef="serviceTask2" targetRef="endTask"/>
    <sequenceFlow id="_2" name="flow9" sourceRef="gatway2" targetRef="serviceTask3"/>
  </process>
  <bpmndi:BPMNDiagram documentation="background=#3C3F41;count=1;horizontalcount=1;orientation=0;width=842.4;height=1195.2;imageableWidth=832.4;imageableHeight=1185.2;imageableX=5.0;imageableY=5.0" id="Diagram-_1" name="New Diagram">
    <bpmndi:BPMNPlane bpmnElement="myProcess">
      <bpmndi:BPMNShape bpmnElement="startEvent" id="Shape-startEvent">
        <omgdc:Bounds height="32.0" width="32.0" x="35.0" y="225.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="32.0" width="32.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="serviceTask1" id="Shape-serviceTask1">
        <omgdc:Bounds height="55.0" width="85.0" x="120.0" y="220.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="55.0" width="85.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="userTask1" id="Shape-userTask1">
        <omgdc:Bounds height="55.0" width="85.0" x="295.0" y="215.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="55.0" width="85.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="gateway1" id="Shape-gateway1" isMarkerVisible="false">
        <omgdc:Bounds height="32.0" width="32.0" x="430.0" y="225.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="32.0" width="32.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="userTask2" id="Shape-userTask2">
        <omgdc:Bounds height="55.0" width="85.0" x="525.0" y="215.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="55.0" width="85.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="serviceTask3" id="Shape-serviceTask3">
        <omgdc:Bounds height="55.0" width="85.0" x="620.0" y="50.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="55.0" width="85.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="gatway2" id="Shape-gatway2" isMarkerVisible="false">
        <omgdc:Bounds height="32.0" width="32.0" x="650.0" y="220.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="32.0" width="32.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="serviceTask2" id="Shape-serviceTask2">
        <omgdc:Bounds height="55.0" width="85.0" x="720.0" y="215.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="55.0" width="85.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="endTask" id="Shape-endTask">
        <omgdc:Bounds height="32.0" width="32.0" x="885.0" y="230.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="32.0" width="32.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNEdge bpmnElement="_13" id="BPMNEdge__13" sourceElement="userTask1" targetElement="exclusivegateway1">
        <omgdi:waypoint x="380.0" y="242.5"/>
        <omgdi:waypoint x="430.0" y="241.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="0.0" width="0.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="_24" id="BPMNEdge__24" sourceElement="_19" targetElement="_20">
        <omgdi:waypoint x="805.0" y="242.5"/>
        <omgdi:waypoint x="885.0" y="246.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="0.0" width="0.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="_23" id="BPMNEdge__23" sourceElement="_18" targetElement="_19">
        <omgdi:waypoint x="682.0" y="236.0"/>
        <omgdi:waypoint x="720.0" y="242.5"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="0.0" width="0.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="_15" id="BPMNEdge__15" sourceElement="exclusivegateway1" targetElement="_11">
        <omgdi:waypoint x="445.0" y="226.0"/>
        <omgdi:waypoint x="445.0" y="115.0"/>
        <omgdi:waypoint x="620.0" y="77.5"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="0.0" width="0.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="_14" id="BPMNEdge__14" sourceElement="exclusivegateway1" targetElement="userTask2">
        <omgdi:waypoint x="462.0" y="241.0"/>
        <omgdi:waypoint x="525.0" y="242.5"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="0.0" width="0.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="_2" id="BPMNEdge__2" sourceElement="_18" targetElement="_11">
        <omgdi:waypoint x="666.0" y="220.0"/>
        <omgdi:waypoint x="666.0" y="105.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="0.0" width="0.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="_4" id="BPMNEdge__4" sourceElement="startEvent" targetElement="userServiceTask">
        <omgdi:waypoint x="67.0" y="241.0"/>
        <omgdi:waypoint x="120.0" y="247.5"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="0.0" width="0.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="_6" id="BPMNEdge__6" sourceElement="userServiceTask" targetElement="userTask1">
        <omgdi:waypoint x="205.0" y="247.5"/>
        <omgdi:waypoint x="295.0" y="242.5"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="0.0" width="0.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="_22" id="BPMNEdge__22" sourceElement="userTask2" targetElement="_18">
        <omgdi:waypoint x="610.0" y="242.5"/>
        <omgdi:waypoint x="650.0" y="236.0"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="0.0" width="0.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="_21" id="BPMNEdge__21" sourceElement="_11" targetElement="_20">
        <omgdi:waypoint x="705.0" y="80.0"/>
        <omgdi:waypoint x="905.0" y="80.0"/>
        <omgdi:waypoint x="905.0" y="230.50806661517032"/>
        <bpmndi:BPMNLabel>
          <omgdc:Bounds height="0.0" width="0.0" x="0.0" y="0.0"/>
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNEdge>
    </bpmndi:BPMNPlane>
  </bpmndi:BPMNDiagram>
</definitions>
